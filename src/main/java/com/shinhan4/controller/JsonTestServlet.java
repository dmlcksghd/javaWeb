package com.shinhan4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.firstzone.dept.DeptService;
import com.firstzone.dept.DeptDTO;

@WebServlet("/json.do")
public class JsonTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = request.getParameter("jsonInfo");
        System.out.println("받은 JSON 데이터: " + json);
        int result = 0;

        if (json == null || json.isEmpty()) {
            response.setContentType("text/plain;charset=utf-8");
            response.getWriter().append("JSON 데이터가 비어 있습니다.");
            return;
        }

        JSONParser parser = new JSONParser();
        try {
            JSONObject obj = (JSONObject) parser.parse(json);
            System.out.println("---- 파싱 후 데이터 추출 ----");

            // JSON 데이터를 String으로 가져와 숫자형으로 변환
            String deptidStr = (String) obj.get("dept_id");
            String midStr = (String) obj.get("mid");
            String locidStr = (String) obj.get("locid");
            String deptname = (String) obj.get("deptname");

            // String 데이터를 Integer로 변환
            Integer deptid = deptidStr != null ? Integer.parseInt(deptidStr) : null;
            Integer mid = midStr != null ? Integer.parseInt(midStr) : null;
            Integer locid = locidStr != null ? Integer.parseInt(locidStr) : null;

            System.out.println("deptid: " + deptid);
            System.out.println("mid: " + mid);
            System.out.println("locid: " + locid);
            System.out.println("deptname: " + deptname);

            // DeptDTO 객체 생성
            DeptDTO dept = DeptDTO.builder()
                .department_id(deptid)
                .department_name(deptname)
                .location_id(locid)
                .manager_id(mid)
                .build();

            // 서비스 호출
            DeptService dService = new DeptService();
            result = dService.insertService(dept);

        } catch (ParseException e) {
            e.printStackTrace();
            response.setContentType("text/plain;charset=utf-8");
            response.getWriter().append("JSON 파싱 오류: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.setContentType("text/plain;charset=utf-8");
            response.getWriter().append("숫자 변환 오류: " + e.getMessage());
            return;
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/plain;charset=utf-8");
            response.getWriter().append("오류 발생: " + e.getMessage());
            return;
        }

        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().append(result + "건 입력되었습니다.");
    }
}
