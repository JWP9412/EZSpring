package com.solero.stsrestful.boards;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
public class BoardController {
	List<ArticleVO> articles;

	public BoardController() {
		articles = new ArrayList<ArticleVO>();
		for (int cnt = 0; cnt < 10; cnt++) {
			ArticleVO article = new ArticleVO();
			article.setArticleNO(1000 + cnt);
			article.setWriter("이젠아카데미");
			article.setTitle("자바풀스텍과정");
			article.setContent("Java:" + cnt);
			articles.add(article);
		}
	}
	
	private ArticleVO searchArticle(Integer articleNO) {
		for (ArticleVO vo : articles) {
			if(articleNO == vo.getArticleNO()) {
				return vo;
			}
		}
		return null;
	}
	
	// 전체 조회
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<ArticleVO>> listArticle() {
		
		return new ResponseEntity<List<ArticleVO>>(articles, HttpStatus.OK);
	}

	// 개별 조회
	@RequestMapping(value="/find/{articleNO}",method=RequestMethod.GET)
	public ResponseEntity<ArticleVO> findArticle(@PathVariable("articleNO") Integer articleNO){
		return new ResponseEntity<ArticleVO>(searchArticle(articleNO),HttpStatus.OK);
		
	}
	
	// 내용 수정
	@RequestMapping(value="/update/{articleNO}",method=RequestMethod.PUT)
	public ResponseEntity<ArticleVO> updateArticle(@PathVariable("articleNO") Integer articleNO,
			@RequestBody ArticleVO articleVO){
		
		System.out.println("[updateArticle] "+ articleVO.toString());
		
		ArticleVO vo = searchArticle(articleNO);
		if(vo != null) {
			return new ResponseEntity(articleNO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity(articleNO,HttpStatus.BAD_REQUEST);
		}
	}
	
	// 내용 삭제
		@RequestMapping(value="/delete/{articleNO}",method=RequestMethod.DELETE)
		public ResponseEntity<String> deleteArticle(@PathVariable("articleNO") Integer articleNO){
			ArticleVO vo = searchArticle(articleNO);
			if(vo != null) {
				return new ResponseEntity("삭제 성공",HttpStatus.OK);
			}
			else {
				return new ResponseEntity("해당 게시물이 없습니다",HttpStatus.BAD_REQUEST);
			}
		}
		
		
		// 내용 등록
		@RequestMapping(value="/add",method=RequestMethod.POST)
		public ResponseEntity<String> addArticle(@RequestBody ArticleVO articleVO){
			
			System.out.println("[addArticle] "+ articleVO.toString());
			
			ArticleVO vo = searchArticle(articleVO.getArticleNO());
			if(vo != null) {
				return new ResponseEntity("[addArticle] Failed!",HttpStatus.BAD_REQUEST);
			}
			else {
				return new ResponseEntity("[addArticle] Succeed!",HttpStatus.OK);
			}
			
			
		}
		
		
	
	
}
