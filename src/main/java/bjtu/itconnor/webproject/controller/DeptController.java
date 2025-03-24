package bjtu.itconnor.webproject.controller;

import bjtu.itconnor.webproject.pojo.Dept;
import bjtu.itconnor.webproject.pojo.Result;
import bjtu.itconnor.webproject.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class DeptController {
       @Autowired  //省略DeptService deptService = new DeptServiceIml(); 并且自动注入
       private DeptService deptService;

       @GetMapping("/depts")
       public Result list(){
           System.out.println("查询全部部门数据");
           List<Dept> deptlist = deptService.findAll();
           return Result.success(deptlist);
       }

       @DeleteMapping("/depts")
       /*public Result delete(HttpServletRequest request) {
           System.out.println("查询全部部门数据");
           String idStr = request.getParameter("id");
           int id = Integer.parseInt(idStr);
           return Result.success();
       }*/


       /*
       public Result delete(@RequestParam("id") Integer id) {
           System.out.println("删除部门数据");
           deptService.deleteById(id);
           return Result.success();
           一旦加了@RequestParam 注解，参数必须传递 默认required=true
       }*/

       public Result delete(Integer id) {
           System.out.println("删除部门数据");
           deptService.deleteById(id);
           return Result.success();
       } //保持输入变量名与形参一致 则无需注解

      @PostMapping("/depts")
      public Result add(@RequestBody Dept dept){
        System.out.println("添加部门数据");
        deptService.addById(dept);
        return Result.success();
    }/*@RequestBody 将请求体中json格式的数据转换为java对象
       而@RequestParam 则是查询URL参数
      */

      @GetMapping("/depts/{id}")
      public Result getInfo(@PathVariable/*("id")*/ Integer id){
        System.out.println("查询部门数据");
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
      @PutMapping("/depts")
      public Result update(@RequestBody Dept dept){
        System.out.println("修改部门数据");
        deptService.updateById(dept);
        return Result.success();
    }


}
