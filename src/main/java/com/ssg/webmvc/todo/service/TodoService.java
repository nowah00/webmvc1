package com.ssg.webmvc.todo.service;
//객체의 개수를 결정할때 사용한다.
// 현재 INSTANCE가 한 개이므로 서비스객체 1개만 사용  TodoService.INSTENCE 접근
//객체를 하나만 생성해서 사용 (singleton pattern)
//여러 컨트롤러들이 TodoService 객체를 통해서 원하는 데이터를 주고받는 구조로 구성
// 장점 : 정해진 수만큼 객체를 생성할 수 있다.

import com.ssg.webmvc.todo.dao.TodoDAO;
import com.ssg.webmvc.todo.domain.TodoVO;
import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;


    TodoService() {
        this.dao = new TodoDAO();
        this.modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        //System.out.println("todoVO :" + todoVO);
        log.info(todoVO);
        dao.insert(todoVO);
        // register() TodoDTO 파라미터를 받아서 ModelMapper를통해 TodoVO객체로 변환을 한후
        //dao.insert(todoVO) 를 통해 todoVO 객체를 전달하며 등록기능을 요청한다.
    }

//    //10개의 TodoDTO 객체를 만들어 반환
//    public List<TodoDTO> getList() {
//        List<TodoDTO> todoDTOS = IntStream.range(0, 10).mapToObj(
//                i -> {
//                    TodoDTO dto = new TodoDTO();
//                    dto.setTno((long) i);
//                    dto.setTitle("Todo..title" + i);
//                    dto.setDueDate(LocalDate.now());
//                    return dto;
//                }
//        ).collect(Collectors.toList());
//        return todoDTOS;
//    }
//
    public TodoDTO get(Long tno) {
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);
        return dto;
    }

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAll();
        log.info("voList-------------");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream().map(
                vo -> modelMapper.map(vo,TodoDTO.class)).collect(Collectors.toList());

        return dtoList;
    }

    public void remove(Long tno)throws Exception {

        log.info("tno: " + tno);
        dao.deleteOne(tno);
    }

    public void modify(TodoDTO todoDTO)throws Exception {

        log.info("todoDTO: " + todoDTO );

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        dao.updateOne(todoVO);

    }

}


