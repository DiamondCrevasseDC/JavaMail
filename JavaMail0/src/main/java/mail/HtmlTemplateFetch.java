package mail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class HtmlTemplateFetch {

    public static String fetchFileContent(String dirPath)
            throws Exception{
        StringBuffer fileContent = new StringBuffer();

        dirPath = dirPath.replaceAll("\\\\", "/");

//        System.out.println("当前Mail文件所在目录：" + dirPath);
        File file = new File(dirPath);
        if (!file.exists()) {
            System.out.println(dirPath + " html is not exist! ");
            return null;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));
        String str = null;
        while((str = br.readLine()) != null){
            fileContent.append(str);
        }

        return fileContent.toString();
    }
}
