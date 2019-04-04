import java.io.*;

public class Main {

    public static void main(String[] args) {
        Main obj = new Main();
        //obj.OutputStreamEx();
        //obj.InputStreamEx();
        //obj.OutputBufferedStream();
        obj.InputBufferedStream();
    }

    //데이터 저장
    public void OutputStreamEx() {
        try {
            OutputStream output = new FileOutputStream("C:\\Users\\yoo\\Desktop\\HELLO_JAVA\\HELLO_JAVA\\Algorithm\\src\\beakjoon\\Mar\\others\\fileclass\\src\\Output.txt");
            String str = "어차피 결말은 해피엔딩!!!";
            byte[] bytes = str.getBytes();
            output.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //파일 불러오기
    public void InputStreamEx() {
        try {
            File file = new File("C:\\Users\\yoo\\Desktop\\HELLO_JAVA\\HELLO_JAVA\\Algorithm\\src\\beakjoon\\Mar\\others\\fileclass\\src\\Output.txt");
            FileReader fileReader = new FileReader(file);
            int cur = 0;
            while ((cur = fileReader.read()) != -1) {
                System.out.print((char) cur);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //BufferedReadOutputStream으로 txt저장
    public void OutputBufferedStream() {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                    new FileOutputStream("C:\\Users\\yoo\\Desktop\\HELLO_JAVA\\HELLO_JAVA\\Algorithm\\src\\beakjoon\\Mar\\others\\fileclass\\src\\OutputStream.txt"));
            String str = "결국 결말은 해피엔딩><";
            bufferedOutputStream.write(str.getBytes());
            bufferedOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //BufferedInputStream으로 txt읽기
    public void InputBufferedStream() {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\yoo\\Desktop\\HELLO_JAVA\\HELLO_JAVA\\Algorithm\\src\\beakjoon\\Mar\\others\\fileclass\\src\\OutputStream.txt");
            byte[] bytes = new byte[fileInputStream.available()];
            while (fileInputStream.read(bytes) != -1) {
            }
            System.out.print(new String(bytes));
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
