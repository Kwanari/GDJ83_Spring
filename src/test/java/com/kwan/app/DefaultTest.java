package com.kwan.app;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*-context.xml" })
//context 경로, 배포전이라 webapp까지의 경로 전부 작성
//** 폴더의 유무 상관없음
public abstract class DefaultTest {

}
