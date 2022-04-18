package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

public class FirstJUnitTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("���� ����� ����������� ����� ����� �������!");
    }

    @BeforeEach
    void before() {
        System.out.println("    ���� ����� ����������� ����� ������ ������!");
    }

    @AfterEach
    void after() {
        System.out.println("    ���� ����� ����������� ����� ������� �����!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("���� ����� ����������� ����� ���� ������!");
    }

    @Test
    void textTest() {
        System.out.println("        ��� ������ ����!");
    }

    @Test
    void videoTest() {
        System.out.println("        ��� ������ ����!");
    }
}