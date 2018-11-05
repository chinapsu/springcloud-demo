package com.dearcloud.provider1.service;

import com.dearcloud.microservicecloud.api.domain.Dept;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeptService {

    private final static ArrayList<Dept> deptDbs = new ArrayList<>();

    static {
        deptDbs.add(new Dept().setId(1L).setName("开发部1").setLocation("北京中关村"));
        deptDbs.add(new Dept().setId(2L).setName("测试部1").setLocation("山西吕梁市"));
        deptDbs.add(new Dept().setId(3L).setName("运维部1").setLocation("上海虹桥"));
        deptDbs.add(new Dept().setId(4L).setName("运营部1").setLocation("山东济南"));
        deptDbs.add(new Dept().setId(5L).setName("财务部1").setLocation("数码科技广场"));
    }

    public boolean add(Dept dept) {
        deptDbs.add(dept);
        return true;
    }

    public Dept get(Long id) {
        if (id == null) return null;
        Optional<Dept> result = deptDbs.stream().filter(s -> id.equals(s.getId())).findFirst();
        return result.orElse(null);
    }

    public List<Dept> list() {
        return deptDbs;
    }

}
