package bjtu.itconnor.webproject.service;

import bjtu.itconnor.webproject.pojo.Dept;

import java.util.List;

public interface DeptService {
      List<Dept> findAll();

      void deleteById(Integer id);

      void addById(Dept dept);

      void updateById(Dept dept);

      Dept getById(Integer id);
}
