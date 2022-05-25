package com.choe.dto;

import com.choe.service.Criteria;

public class PageDTO {
	// Start와 End가 변수로 저장이 되어져 있어야하고 소숫점이 없기때문에 INT형 타입으로 저장한다.
	// 시작
	private int startPage;
	// 끝
	private int endPage;
	// 이전과 다음버튼의 경우 경우에 따라 안보여지는 경우가 있으니 타입은 boolean 타입으로 사용을 하는 것이 좋음
	// 이전
	private boolean prev;
	// 다음
	private boolean next;
	// 전체건수를 살리는 변수가 필요
	// 전체 건수
	private int total;
	
	// PageDTO 클래스에 Criteria 클래스를 포함시켜 저장하고자 하는 변수 선언
	private Criteria cri;
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		// 사용자가 선택한 페이지 번호
		// Math.ceil은 더블형으로 주닌깐 double로 됨 [강제형변환]
		this.endPage = (int)(Math.ceil(cri.getPagenum() / 10.0))*10;
		this.startPage = this.endPage - 9;
		
		// 전체건수 / 한페이지 당 게시판 갯수
		int realEnd = (int)(Math.ceil(total*1.0 / cri.getAmount()));
		
		// endPage변수에 저장되어 있는 값보다 realEnd값이 작으면
		if(realEnd < this.endPage) {
			// realEnd값을 endPage변수에 저장.
			this.endPage = realEnd;
		}
		
		// 2) 이전, 다음 버튼 어떤식 처리
		// 이전(보다 크닌깐 false)
		this.prev = this.startPage > 1;
		
		// 다음
		this.next = this.endPage < realEnd;
	}
	
	@Override
	public String toString() {
		return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}
	

	
	
	
	
}
