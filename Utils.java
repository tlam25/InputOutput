import java.io.*;

public class Utils {
    /**
     * readContentFromFile (đọc một tệp .txt từ ổ cứng).
     */
    public static String readContentFromFile(String path) {
        StringBuilder content = new StringBuilder();
        try {
            File file = new File(path);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    /**
     * writeContentToFile (ghi đè nội dung vào tệp).
     */
    public static void writeContentToFile(String path, String content) {
        try {
            File file = new File(path);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * writeContentToTheEndOfFile (thêm nội dung vào cuối tệp).
     */
    public static void writeContentToTheEndOfFile(String path, String content) {
        try {
            File file = new File(path);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * findFileByName (tìm kiếm tệp trong thư mục).
     */
    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    return file;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String filePath = "test.txt";
        String content = "Hello, World!";

        // Ghi đè nội dung vào tệp
        Utils.writeContentToFile(filePath, content);

        // Đọc nội dung từ tệp
        String fileContent = Utils.readContentFromFile(filePath);
        System.out.println("Nội dung trong tệp sau khi ghi đè:");
        System.out.println(fileContent);

        // Ghi thêm nội dung vào cuối tệp
        String additionalContent = "\nThêm nội dung mới";
        Utils.writeContentToTheEndOfFile(filePath, additionalContent);

        // Đọc nội dung từ tệp sau khi ghi thêm
        fileContent = Utils.readContentFromFile(filePath);
        System.out.println("Nội dung trong tệp sau khi ghi thêm:");
        System.out.println(fileContent);
    }
}