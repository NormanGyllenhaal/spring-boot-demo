package site.lovecode.boot.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import site.lovecode.boot.entity.Country;
import site.lovecode.boot.repository.CountryRepository;

import java.util.List;


@RestController
@RequestMapping("/api/test")
public class SimpleController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(value = "/country", method=RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @ApiOperation(value="测试接口", notes="测试接口详细描述")
    public List<Country> hello(Integer id){
        List<Country> list = countryRepository.findAll();
        return list;
    }

}