package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    private final String filePath = this.getClass().getPackage().toString().replace('.', '/').replaceFirst("package ", "./src/")+"/vacancies.html";
    private Controller controller;
    private List<Vacancy> vacancies;

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException {
        Document doc = null;
        doc = getDocument();

        Element element = doc.getElementsByClass("template").first();
        Element elementclon = element.clone();

        elementclon.removeClass("template").removeAttr("style");
        doc.select("tr[class*=\"vacancy\"]").not("tr[class=\"vacancy template\"]").remove();

        for (Vacancy vacancy : vacancies){
            Element vac = elementclon.clone();
            vac.getElementsByAttributeValue("class", "city").get(0).text(vacancy.getCity());
            vac.getElementsByAttributeValue("class", "companyName").get(0).text(vacancy.getCompanyName());
            vac.getElementsByAttributeValue("class", "salary").get(0).text(vacancy.getSalary());
            vac.getElementsByTag("a").get(0).text(vacancy.getTitle()).attr("href", vacancy.getUrl());
            element.before(vac.outerHtml());

        }

        return doc.html();
    }

    private void updateFile(String s) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(s);
        fileWriter.close();
    }

    @Override
    public void update(List<Vacancy> vacancies) {

        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (IOException e) {
            System.out.println("Some exception occurred");
        }
    }

    @Override
    public void setController(Controller controller) {

        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Izhevsk");
    }

    protected Document getDocument() throws IOException{
        File file = new File(filePath);
        Document document = Jsoup.parse(file,"UTF-8");
        return document;

    }
}
