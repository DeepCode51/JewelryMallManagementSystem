package com.test.controller;

import com.test.obj.Classify;
import com.test.obj.ResultMap;
import com.test.obj.Series;
import com.test.obj.SeriesPage;
import com.test.service.AdminSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin/series")
public class AdminSeriesController {

    @Autowired
    AdminSeriesService adminSeriesService;

    @RequestMapping("")
    public String index(){
        return "admin/series";
    }

    @RequestMapping("/getclassify")
    @ResponseBody
    public List<Classify> getclassify(){
        System.out.println("啊啊啊啊"+adminSeriesService.getClassify().toString());
        return adminSeriesService.getClassify();
    }

    @RequestMapping("series_list")
    @ResponseBody
    public ResultMap<List<Series>> series_list(SeriesPage page, @RequestParam("limit") int limit,@RequestParam(value = "search",defaultValue = "")String name){
        page.setRows(limit);
        if (name.length()>0){
            return adminSeriesService.search(page,name);
        }else {
            return adminSeriesService.series_list(page);
        }

    }

    @RequestMapping("byClassify")
    @ResponseBody
    public ResultMap<List<Series>> byClassify(@RequestParam("classify") int classyfyId){
        SeriesPage page = new SeriesPage();
        page.setClassify(classyfyId);
        return adminSeriesService.series_classify(page);
    }

    @RequestMapping("/series_edit")
    public String seires_edit_h(@RequestParam("id") Integer id, Model model){
        Series res = adminSeriesService.search_id(id);
        model.addAttribute("series", res);
        return "admin/series_edit";
    }

    @RequestMapping("/series_edit.do")
    @ResponseBody
    public int series_edit(Series series){

        return adminSeriesService.update(series);
    }

    @RequestMapping("/upload.do")
    public String upload(@RequestParam("file")MultipartFile multipartFile, @RequestParam("id") Integer id){
        int r = adminSeriesService.upload(multipartFile,id);
        return "redirect:/admin/series/upload?id=" + id;

    }

    @RequestMapping("/upload")
    public String upload_h(@RequestParam("id")Integer id, Model model){
        model.addAttribute("id", id);
        return "admin/series_pic_upload";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int delete(@RequestParam("id") Integer id){
        return adminSeriesService.delete(id);
    }

    @RequestMapping("/insert.do")
    @ResponseBody
    public int insert(Series series){
        return adminSeriesService.insert(series);
    }

    @RequestMapping("/insert")
    private String insert_h(){
        return "admin/series_add";
    }

}
