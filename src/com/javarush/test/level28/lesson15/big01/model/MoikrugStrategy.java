package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";


    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancies = new ArrayList<>();
        try
        {
            int page = 0;
            while (true)
            {
                Document doc = getDocument(searchString, page++);
                Elements element = doc.getElementsByClass("job");
                if (!element.isEmpty())
                {
                    for (Element el : element)
                    {
                        Vacancy vacancy = new Vacancy();
                        vacancy.setTitle(el.getElementsByClass("title").text());
                        vacancy.setSalary(el.getElementsByClass("count").text());
                        vacancy.setCity(el.getElementsByClass("location").text());
                        vacancy.setCompanyName(el.getElementsByClass("company_name").select("a[href]").text());
                        vacancy.setSiteName("https://moikrug.ru");
                        vacancy.setUrl(el.getElementsByClass("title").select("a").attr("abs:href"));
                        vacancies.add(vacancy);
                    }
                }
                else break;
            }
        }
        catch (IOException e)
        {

        }


        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, searchString, page);
        Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64)").referrer("google").get();
        return document;
    }
}
