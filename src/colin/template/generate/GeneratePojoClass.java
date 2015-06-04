package colin.template.generate;

import colin.template.vo.PojoFieldVo;
import colin.template.vo.PojoVo;
import org.apache.log4j.Logger;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ASUS on 2015/2/16.
 * 创建生成POJO的class
 */
public class GeneratePojoClass {

    Logger logger = Logger.getLogger(GeneratePojoClass.class);
    private File xmlFile;

    public GeneratePojoClass() {
        ClassPathResource xmlFileResource = new ClassPathResource("/colin/template/configXml/pojo.xml");
        try {
            xmlFile = xmlFileResource.getFile();
        } catch (IOException e) {
            logger.error("获取xml文件出错！");
            e.printStackTrace();
        }
    }

    /**
     * 加载DOM文件
     */
    public void generatePojoResource() throws DocumentException, IOException {
        //从类路径加载文件资源
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(xmlFile);
        Element rootElement = document.getRootElement();//获取xml根元素pojos
        //拼装循环的数据集合
        List<Element> pojoEles = rootElement.elements("pojo");
        List<PojoVo> pojoList = new ArrayList<PojoVo>();
        for (Element currentEle : pojoEles) {
            if(!Boolean.valueOf(currentEle.attributeValue("hasGenerate"))){
                PojoVo pojoVo = new PojoVo();
                pojoVo.setTableName(currentEle.attributeValue("tableName"));
                pojoVo.setClassName(currentEle.attributeValue("className"));
                List<Element> fieldsList = currentEle.elements("field");
                List<PojoFieldVo> fieldVosList = new ArrayList<PojoFieldVo>();
                for (Element currentFieldEle : fieldsList) {
                    PojoFieldVo fieldVo = new PojoFieldVo();
                    fieldVo.setFiledName(currentFieldEle.attributeValue("name"));
                    fieldVo.setPrimaryKey(Boolean.valueOf(currentFieldEle.attributeValue("primaryKey")));
                    fieldVo.setDataLength(Integer.valueOf(currentFieldEle.attributeValue("dataLength")));
                    fieldVo.setDataType(currentFieldEle.attributeValue("dataType"));
                    fieldVo.setFieldDesc(currentFieldEle.attributeValue("fieldDesc"));
                    fieldVosList.add(fieldVo);
                }
                pojoVo.setFieldVoList(fieldVosList);
                pojoList.add(pojoVo);
            }else{
                continue;
            }

        }
        generateClassFile(pojoList);

    }

    /**
     * 自动生成代码文件
     */
    public void generateClassFile(List<PojoVo> pojoList) throws IOException {
        //模板加载器
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate loadPojoTemplate = new GroupTemplate(resourceLoader, cfg);
        //自动生成文件
        for (PojoVo pojoVo : pojoList) {
            Template template = loadPojoTemplate.getTemplate("/colin/template/pojoTemplate/PojoGenerateTemplate.template");
            template.binding("className", pojoVo.getClassName());
            template.binding("tableName", pojoVo.getTableName());
            template.binding("fieldList", pojoVo.getFieldVoList());
            //输出文件
            FileSystemResource pojoFileResource = new FileSystemResource("D:\\Dev_Intellij_Program\\HomeCenterService\\src\\colin\\app\\core\\pojo");
            File entityFile = new File(pojoFileResource.getFile().getPath() + File.separator + pojoVo.getClassName() + ".java");
            if (!entityFile.exists()) {
                entityFile.createNewFile();
            }
            FileOutputStream pojoClassFile = new FileOutputStream(entityFile);
            template.renderTo(pojoClassFile);
            System.out.println("模板文件生成成功!");
        }
    }

    public static void main(String[] args) {
        GeneratePojoClass generatePojoClass = new GeneratePojoClass();
        try {
            generatePojoClass.generatePojoResource();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
