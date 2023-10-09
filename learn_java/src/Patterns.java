import java.util.Scanner;


public class Patterns {

    static void square(int n){
        for (int i=0; i<n; ++i){
            for (int j=0; j<n; ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void hollow_sqaure(int n){
        for (int i=0; i<n; ++i){
            for (int j=0; j<n; ++j){
                if (i==0 || j==0 || i==n-1 || j==n-1) System.out.print("* ");
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void right_triangle(int n){
        for (int i=0; i<n; ++i){
            for (int j=0; j<=i; ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void invert_right_triangle(int n){
        for (int i=0; i<n; ++i){
            for (int j=0; j<n-i; ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void left_triangle(int n){
        for (int i=0; i<n; ++i){
            for (int j=0; j<n-i-1; ++j){
                System.out.print("  ");
            }
            for (int j=0; j<=i; ++j){
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    static void number_right_triangle(int n){
        for (int i=0; i<n; ++i){
            for (int j=0; j<=i; ++j){
                System.out.print((j+1) + " ");
            }
            System.out.println();
        }
    }

    static void number_invert_right_triangle(int n){
        for (int i=0; i<n; ++i){
            for (int j=0; j<n-i; ++j){
                System.out.print((j+1) + " ");
            }
            System.out.println();
        }
    }

    static void floyd_triangle(int n){
        int cnt = 1;
        for (int i=0; i<n; ++i){
            for (int j=0; j<=i; ++j){
                System.out.print(cnt + " ");
                ++cnt;
            }
            System.out.println();
        }
    }

    static void binary_triangle(int n){
        boolean flag = true;
        for (int i=0; i<n; ++i){
            if (i%2==0) flag = true;
            else flag = false;
            for (int j=0; j<=i; ++j){
                System.out.print((flag ? 1 : 0) + " ");
                if (flag) flag = false;
                else flag = true;
            }
            System.out.println();
        }
    }

    static void butterfly(int n){
        for (int i=0; i<n; ++i){
            for (int j=0; j<=i; ++j){
                System.out.print("* ");
            }
            for (int j=0; j<(2*n - 1) - 2*i - 1; ++j){
                System.out.print("  ");
            }
            for (int j=0; j<=i; ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i=n-1; i>=0; --i){
            for (int j=0; j<=i; ++j){
                System.out.print("* ");
            }
            for (int j=0; j<(2*n - 1) - 2*i - 1; ++j){
                System.out.print("  ");
            }
            for (int j=0; j<=i; ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void solid_rhombus(int n){
        for (int i=0; i<n; ++i){
            for (int j=0; j<n-i-1; ++j){
                System.out.print("  ");
            }
            for (int j=0; j<n; ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void number_pyramid(int n){
        for (int i=0; i<n; ++i){
            for (int j=0; j<n-i-1; ++j){
                System.out.print(" ");
            }
            for (int j=0; j<=i; ++j){
                System.out.print((i+1) + " ");
            }
            System.out.println();
        }
    }

    static void palindrome_pattern(int n){
        for (int i=0; i<n; ++i){
            for (int j=0; j<n-i-1; ++j){
                System.out.print("  ");
            }
            for (int j=i+1; j>0; --j){
                System.out.print(j + " ");
            }
            for (int j=2; j<=i+1; ++j){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void diamond_pattern(int n){
        for (int i=0; i<n; ++i){
            for (int j=0; j<n-i-1; ++j){
                System.out.print("  ");
            }
            for (int j=0; j<2*i+1; ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i=n-2; i>=0; --i){
            for (int j=0; j<n-i-1; ++j){
                System.out.print("  ");
            }
            for (int j=0; j<2*i+1; ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

//        square(input.nextInt());
//        hollow_sqaure(n);
//        right_triangle(n);s
//        invert_right_triangle(n);
//        left_triangle(n);
//        number_right_triangle(n);
//        number_invert_right_triangle(n);
//        floyd_triangle(n);
//        binary_triangle(n);
//        butterfly(n);
//        solid_rhombus(n);
//        number_pyramid(n);
//        palindrome_pattern(n);
//        diamond_pattern(n);
    }
}