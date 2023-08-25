package view;

import java.util.Scanner;

import model.Figure;
import presenter.Presenter;

public class Runner {
	Presenter presenter = new Presenter();
	Scanner input;

	public static void main(String[] args) {

		Runner runner = new Runner();
		runner.input = new Scanner(System.in);
		runner.menu();

	}

	public void menu() {

		String option;
		boolean j = false;
		int side = 0;
		int width = 0;
		int high = 0;
		int down = 0;
		int up = 0;
		int right = 0;
		int left = 0;
		boolean flag = false;

		String color = "blue";
		String name = "";
		boolean optionVisible;
		 
		do {
		System.out.println("  Choose figure  \n" + "1. Circle \n" + "2. Square \n"
				+ "3. Triangle \n" + "4. Star \n" + "5. Leave \n" + "  <<<  please select an option >>>");
		option = input.next();
		
		if (option.matches("[1-5]")== true) {
			flag =false;
		}else {
			System.out.println(" <<<<< ERROR >>>>>");
			flag =true;
		}
		}while( flag == true);
			
	
			switch (option) {
			case "1":
					System.out.println(" --------------- CIRCLE  ------------------");
					name = "circle";
				
				break;
			case "2":
				System.out.println(" --------------- SQUARE  ------------------");
				name = "square";
	
				break;
	
			case "3":
				j = true;
				System.out.println(" --------------- TRIANGLE  ------------------");
				name = "triangle";	
				break;
			case "4":
				j = true;
				System.out.println(" ---------------  STAR  ------------------");
				name = "star";
				break;
			case "5":
				System.out.println("close pragram!!!");
				System.exit(0);
	
			}
		
		Figure figure = presenter.getFigure(name);
		int optionWhile=0;

		/////
		flag = false;

		do {
			do {
				input.nextLine();
			try {
				System.out.println(" Do you want to perform any action on your figure?  \n" + "1. Yes \n" + "2. No \n" + "Enter option  \n");
				optionWhile = input.nextInt();
				if (optionWhile >0 && optionWhile<3) {
					flag=false;
				}else {
					flag=true;
				}
				
			} catch (Exception e) {
				System.out.println("<<<<< ERROR >>>>>");
				flag= true;
			}
			}while(flag == true);
		
			if (optionWhile == 1) {
				do {
				System.out.println(
						" what action are you going to take? \n" + "1. Make visible \n" + "2. size \n" + "3. Move with movement \n"
								+ "4. Move \n" + "5. Color  \n" + "6. Make invisible \n" + "7. Leave ");
				option = input.next();

				if (option.matches("[1-7]")== true) {
					flag =false;
				}else {
					System.out.println(" <<<<< ERROR >>>>>");
					flag =true;
				}
				}while(flag== true);

				switch (option) {
				case "1":
					
					optionVisible= true;
					figure.makeVisible(optionVisible);
					break;
					
				case "2":
					do {
						input.nextLine();
						flag=false;
						try {
							
							if (j) {
								System.out.print("Enter a new height: ");
								high = input.nextInt();
								
								System.out.print("Enter a new width: ");
								width = input.nextInt();
								
								
							} else {
								System.out.print(" Enter a new size: ");
								side = input.nextInt();
									
								
								
							}
					          if (high>=0 && width>=0 && side>=0 ) {
					        	  figure.newSize(high,width);
					        	  figure.newSize(side);
					        	  flag=false;
					         }else {
					        	 System.out.println(" <<<<<< number error >>>>>>");
								flag=true;
							}
							
							} catch (Exception InputMismatchException) {
								System.out.println(" <<<<<<<< ERROR >>>>>>>> ");
								flag=true;
							}
						}while(flag==true);
					break;
				case "3":
					do {
						input.nextLine();
					try {
						flag = true;
						
						System.out.println("Enter the number of pixels to traverse in each direction.");
						System.out.print("Right : ");
						right = input.nextInt();
						System.out.print("Left : ");
						left = input.nextInt();
						System.out.print("Up : ");
						up = input.nextInt();
						System.out.print("Down : ");
						down = input.nextInt();
						
						if (right >=0 && left >=0 && up>=0 && down>=0) {
							figure.slowMoveHorizontal(right);
							figure.slowMoveHorizontal(-(left));
							figure.slowMoveVertical(-(up));
							figure.slowMoveVertical(down);
						}else {
							System.out.println(" <<<<<<< negative numbers error >>>>>>> ");
							flag= false;
						}
						
					} catch (Exception InputMismatchException) {
						System.out.println(" <<<<<<<< ERROR >>>>>>>> ");
						flag=false;
					}
					}while(flag==false);
					break;

				case "4":
					do {
						input.nextLine();
						try {
							flag = true;
							System.out.println("Enter the number of pixels to traverse in each direction. ");
							System.out.print("Right : ");
							right = input.nextInt();
							System.out.print("Left : ");
							left = input.nextInt();
							System.out.print("Up : ");
							up = input.nextInt();
							System.out.print("Down");
							down = input.nextInt();
							if (right >=0 && left >=0 && up>=0 && down>=0) {
							figure.moveVertical(down);
							figure.moveVertical(-(up));
							figure.moveHorizontal(right);
							figure.moveHorizontal(-(left));
							}else {
								System.out.println(" <<<<<<< negative numbers error >>>>>>> ");
								flag= false;
							}
						
						} catch (Exception InputMismatchException) {
							System.out.println(" <<<<<<<< ERROR >>>>>>>> ");
							flag=false;
						}
					}while(flag==false);
					break;
				case "5":
					do {
						System.out.println(" What color do you want to change to? \n"
								+ "red, black, blue, yellow, green, magenta, white\n" + " Enter new color \n ");
						color = input.next();
						switch (color) {
						case "red":
						case "black":
			            case "blue":
			            case "yellow":
			            case "green":
			            case "magenta":
			            case "white":
			            	
			            	figure.chanceColor(color);
			             flag=false;
			                break;
			            default:
			                System.out.println("Invalid color choice.");
			                flag=true;
			                break;
						}
						}while (flag==true);
					

					break;
				case "6":
					figure.makeInvisible();
					break;
				case "7":
					System.out.println(" <<<< close program >>>> ");
					System.exit(0);
					break;

				}
			} else {
				System.out.println("------- new figure -------");
				figure.erase();
				menu();
				
			}
		} while (optionWhile == 1);

	}

}
