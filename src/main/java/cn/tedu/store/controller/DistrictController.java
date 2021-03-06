package cn.tedu.store.controller;

import cn.tedu.store.entity.District;
import cn.tedu.store.service.IDistrictService;
import cn.tedu.store.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("districts")
public class DistrictController
        extends BaseController {

    @Autowired
    private IDistrictService districtService;

    @GetMapping("/")
    public ResponseResult<List<District>>
    getListByParent(
            @RequestParam("parent") String parent) {
        List<District> data
                = districtService
                .getListByParent(parent);
        return new ResponseResult<List<District>>(
                SUCCESS, data);
    }

}







