package junit;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

public class FirstJunitTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("���� ����� ����������� ����� ����� �������");
    }


    @BeforeEach
    void before() {
        System.out.println("���� ����� ����������� ����� ������ ������");
    }

    @AfterEach
    void after() {
        System.out.println("���� ����� ����������� ����� ������� �����");
    }

    @Test
    void testTest() {
        System.out.println("��� ������ ����");
    }

    @Test
    void videoTest() {
        System.out.println("��� ������ ����");
    }
}
