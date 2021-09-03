[JUnit test]

[실행순서]
1. @BeforeClass
2. @Before
3. @Test
4. @After
5. @AfterClass

[실행단위]
1. Test 단위로 테스트 클래스가 생성되고 소멸
2. Before, After를 지정하게 되면 Test를 기준으로 다음과 같이 실행
   - Before -> Test -> After 
   - Before -> Test -> After 
   - Before -> Test -> After 
3. BeforeClass, AfterClass를 지정하게 되면 Test를 기준으로 다음과 같이 실행
   - BeforeClass
   - Before -> Test -> After
   - Before -> Test -> After
   - Before -> Test -> After
   - AfterClass
   