package service;

import model.Conta;
import org.junit.*;

import java.util.Scanner;

public class ContaServiceTest {

    /**
     *
     *  Deve ser possível criar uma conta - OK
     *  Novas contas iniciam com o saldo ZERO
     *  Deve ser possível depositar
     *  Caso haja saldo deve ser possível sacar
     *  Caso haja saldo deve ser possível transferir entre contas
     *
     */

    ContaService contaService;
    Scanner input;

    @BeforeClass
    public static void setup2() {
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void tearDown2() {
        System.out.println("AfterClass");
    }

    @Before // Antes de cada teste executa uma ação
    public void setup() {
        System.out.println("Before");
        contaService = new ContaService();

        input = new Scanner(System.in);
    }

    @After
    public void tearDown() {
        System.out.println("After");
        input.close();
    }

    @Test
    public void deveSerPossivelCriarUmaConta() {
        System.out.println("deveSerPossivelCriarUmaConta");
        // Dado:

        // Quando:
        Conta conta = contaService.cadastrar("Beatriz");

        // Entao:
        Assert.assertTrue(1 == conta.getAgencia());
        Assert.assertTrue(1 == conta.getNumero());
        Assert.assertEquals("Beatriz", conta.getNomeDoCliente());
    }

    @Test
    public void novasContasDevemIniciarComSaldoZero() {
        System.out.println("novasContasDevemIniciarComSaldoZero");
        // Dado
        Conta conta = contaService.cadastrar("Beatriz");

        // Então
        Assert.assertTrue(conta.getSaldo() == 0);
    }

    @Test
    public void deveSerPossivelDepositar() {
        System.out.println("deveSerPossivelDepositar");
        // Dado
        Conta conta = contaService.cadastrar("Beatriz");

        // Quando
        contaService.depositar(conta, 10.0);

        // Entao
        Assert.assertTrue(conta.getSaldo() == 10.0);
    }

    @Test

    public void assertsPossiveis() {
        Assert.assertTrue(true);
        Assert.assertFalse(false);

        // Numeros inteiros
        Assert.assertEquals(1, 1);
        Assert.assertEquals(100000, 100000);

        // Numeros ponto flutuante
        Assert.assertEquals(0.5, 0.5, 0.1);
        Assert.assertEquals(0.51, 0.52, 0.1);
        // Assert.assertEquals(0.51, 0.52, 0.01);

        // Dizimas periodicas infinitas
        Assert.assertEquals(3.141599999999, Math.PI, 0.001);

        // primitivos -> int, short, long, fload, double...
        // wrapper classes -> Integer, Short, Long, Float, Double...
        int intPrimitivo = 10;
        Integer integerWrapper = 10;

        Assert.assertEquals(Integer.valueOf(intPrimitivo), integerWrapper);
        Assert.assertEquals((Integer) intPrimitivo, integerWrapper);
        Assert.assertEquals(intPrimitivo, integerWrapper.intValue());

        Assert.assertEquals("jose", "jose");

        Assert.assertTrue("Maria".equalsIgnoreCase("maria"));

        Assert.assertNotEquals(2 , 10);

        Conta conta01 = new Conta(1, 1, "Marcos");
        Conta conta02 = new Conta(1, 1, "Marcos");

        // Object - equals()
        // Conta - equals()

        // Considera o método equals
        Assert.assertEquals(conta01, conta02);

        // Valida que é a mesma instancia
        Assert.assertSame(conta01, conta01);
        Assert.assertNotSame(conta01, conta02);

        // Expected - esperado | Actual - atual

        Assert.assertEquals("Mensagem de erro do igor", 2, 2);
    }
}
