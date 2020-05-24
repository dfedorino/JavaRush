enum Day{
	MONDAY("Понедельник"),
  	TUESDAY("Вторник"),
  	WEDNESDAY("Среда"),
  	THURSDAY("Четверг"),
  	FRIDAY("Пятница"),
  	SATURDAY("Суббота"),
  	SUNDAY("Воскресенье");
      
  	private String title;
  
  	Day(String title){
    	this.title = title;
  	}
  
  	@Override
  	public String toString(){
  		return "День: " + title;
  	}
}

class Schedule{
  
  private Day today;
  
  public Schedule(){
  	this(Day.MONDAY);
  }
  
  public Schedule(Day today){
  	this.today = today;
  }
  
  public String morningThoughts(){
    String phrase = today == Day.SATURDAY || 
      		    today == Day.SUNDAY ? "Выходной, на работу не надо." : 
    				          "Будний день, все равно на работу не надо, ведь карантин.";
    return phrase;
    
  }
}

class BelorussianDiet{
	private Day today;
  
  	public BelorussianDiet(){
  		this(Day.MONDAY);
    }
  
  	public BelorussianDiet(Day today){
  		this.today = today;
    }
  
  	public String whatToEatToday(){
      String meal;
      // enum можно использовать в switch
      switch(today){
      	case MONDAY:
        	meal = "Картошка";
        	break;
        case TUESDAY:
        	meal = "Картошка";
        	break;
        case WEDNESDAY:
        	meal = "Картошка";
        	break;
        case THURSDAY:
        	meal = "Картошка";
        	break;
        case FRIDAY:
        	meal = "Картошка";
        	break;
        case SATURDAY:
        	meal = "Картошка";
        	break;
        case SUNDAY:
        	meal = "Картошка";
        	break;
        default:
        	meal = "Картошка";
        	break;
      }
      return meal;
    }
}

public class MyFirstEnum{
  public static void main(String[] args){
    
    
  	Schedule s = new Schedule(Day.MONDAY);
    System.out.println(s.morningThoughts());
    
    
    BelorussianDiet bd = new BelorussianDiet(Day.MONDAY);
    System.out.println(bd.whatToEatToday());
    
    // c помощью метода values() выводим все значения
    for(Day d : Day.values()){
    	System.out.println(d.toString());
    }
    
    // смотрим порядковый номер константы (или под каким индексом она находится в values())
    for(Day d : Day.values()){
    	System.out.println(d + " находится на " + d.ordinal() + "-м месте");
    }
    
    // смотрим, какой объект соответствует переданному имени
    System.out.println(Day.valueOf("SUNDAY"));
  }
}
