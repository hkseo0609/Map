package com.hanbit.member.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.hanbit.member.constants.Butt;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;
import com.hanbit.member.serviceImpl.MemberServiceImpl;


public class MemberController {
	public static void main(String[] args){
		MemberService service = new MemberServiceImpl();
		MemberBean member = null;
		Butt[] buttons = {Butt.EXIT,Butt.ADD,Butt.LIST,Butt.FIND_NAME,Butt.FIND_ID,Butt.COUNT,Butt.UPDATE,Butt.DEL};
		
		do{
			flag:
			switch((Butt)JOptionPane.showInputDialog(
					null,//frame
					"member admin", //frame title
					"select menu", //order
					JOptionPane.QUESTION_MESSAGE, //type
					null, //icon
					buttons, //array of choices
					buttons[1] //default
							)){
			case EXIT:
				JOptionPane.showMessageDialog(null, "종료합니다.");
			return;
			case ADD:
				member = new MemberBean();
				String[] arr = (JOptionPane.showInputDialog("NAME/ID/PASSWORD/SSN")).split("/");
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPwd(arr[2]);
				member.setSsn(arr[3]);
				service.addMember(member);
				JOptionPane.showMessageDialog(null, "회원가입 성공!");
			break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, service.countMembers());
				
			break flag;
			case LIST:
				JOptionPane.showMessageDialog(null, service.getMembers());
			break flag;
			case FIND_ID:
				JOptionPane.showMessageDialog(null, service.findByid(JOptionPane.showInputDialog("검색할 아이디를 입력하세요")));
			break flag;
			case FIND_NAME:
				JOptionPane.showMessageDialog(null, service.findName(JOptionPane.showInputDialog("검색할 이름을 입력하세요")));
			break flag;
			case UPDATE: 
				MemberBean bean = new MemberBean();
				String[] arr2 = JOptionPane.showInputDialog("ID와 변경할 NAME/PWD/SSN").split("/");
				bean.setId(arr2[0]);
				bean.setName(arr2[1]);
				bean.setPwd(arr2[2]);
				bean.setSsn(arr2[3]);
				service.updatePass(bean);
				JOptionPane.showMessageDialog(null, "수정 완료");
			break flag;
			case DEL: 
				service.deleteId(JOptionPane.showInputDialog("삭제하려는 아이디를 입력하세요"));
				JOptionPane.showMessageDialog(null, "삭제 완료");
			break flag;
			
			}
		}while(true);
	}

}
