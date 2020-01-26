package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.StringTokenizer;

public class Reader {

    public void importer() throws IOException {
        Path filePath = Paths.get("./sample.csv");
        Objects.requireNonNull(filePath);
        RecordImportDto dto = readCsv(filePath);
        
    }

    public RecordImportDto readCsv(Path filePath){
        RecordImportDto dtos = new RecordImportDto();
        try (BufferedReader buf = Files.newBufferedReader(filePath)) {
            String line = "";
            buf.readLine();
            while((line = buf.readLine()) != null){
                if(line.contentEquals("¥n")){
                    break;
                }
                StringTokenizer st = new StringTokenizer(line,",");
                if(st.countTokens() != 9){
                    System.out.println(st.countTokens());
                    throw new IllegalStateException(String.format("項目数が正しくありません", st.countTokens()));
                }

                ColumnImportDto dto = new ColumnImportDto();
                dto.setCode(st.nextToken());
                dto.setName(st.nextToken());
                dto.setOld(st.nextToken());
                dto.setBlood(st.nextToken());
                dto.setFrom(st.nextToken());
                dto.setBrother(st.nextToken());
                dto.setBusiness(st.nextToken());
                dto.setBirth(st.nextToken());
                dto.setTall(st.nextToken());

                dtos.getRecords().add(dto);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dtos;
    }

}