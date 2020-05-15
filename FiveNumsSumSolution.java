/* 
 * Задача: 	Вывести на экран сумму чисел от 1 до 5 построчно (должно быть 5 строк). 
 * 		   	Не использовать для решения циклы.
 *
 * Решение: Алгоритм позволяет выводить в консоль суммы чисел начиная с числа 
 * 			firstNum с шагом, который определяется в переменной increment.
 * 			Можно вывести в консоль сколь угодно сумм, скопировав вызов функции нужное 
 * 			кол-во раз.
 */

public class FiveNumsSumSolution{
  private static int firstNum = 1;
  private static int increment = 1; /* шаг, с которым определяется следующее число, если 1, то будет 1+2+3+4+5,
                                                                                    если 2, то будет 1+3+5+7+9, и тд.*/
  private static int nextNum = firstNum + increment;
  
  private static void printSum(){
    System.out.println(firstNum + nextNum);
    firstNum = firstNum + nextNum;
    nextNum = nextNum + increment;
  }
  
  
  public static void main(String[] args){
    System.out.println(firstNum); // 1
    printSum(); // 3
    printSum(); // 6
    printSum(); // 10
    printSum(); // 15
  }
}
