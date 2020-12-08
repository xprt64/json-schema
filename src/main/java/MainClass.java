import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MainClass {


    public static void main(String args[]) {

//        String jsonSchema = JsonSchemaGenerator.getJsonSchema(ceva.command.AdaugaPersoana.class);
//        System.out.println(jsonSchema);
//        try {
//            write("D:\\gica\\tmp\\obs\\src\\" + ceva.command.AdaugaPersoana.class.getSimpleName() + ".schema.json", jsonSchema);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void write(String fileName, String schema) throws IOException {
        Path path = Paths.get(fileName);
        byte[] strToBytes = schema.getBytes();

        Files.write(path, strToBytes);
    }
}