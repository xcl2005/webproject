package bjtu.itconnor.webproject.service.iml;

import bjtu.itconnor.webproject.mapper.DeptMapper;
import bjtu.itconnor.webproject.pojo.Dept;
import bjtu.itconnor.webproject.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceIml implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void addById(Dept dept) {
        deptMapper.addById(dept);
    }


    @Override
    public void updateById(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateById(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.findById(id);
    }
}
