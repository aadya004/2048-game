import java.util.*;
public class _2048_game
{
    int ar[][],n,s;
    _2048_game()
    {
        s=0;
        n=0;
        ar=new int[n][n];
    }

    _2048_game(int nn)
    {
        s=0;
        n=nn;
        ar=new int[n][n];
    }

    void time_delay()
    {
        int i,j,k;
        for(i=-10000;i<50000;i++)
            for(k=-100000;k<50000;k++)
                for(j=0;j<100000;j++);
        System.out.print("3...");
        for(i=-10000;i<50000;i++)
            for(k=-100000;k<50000;k++)
                for(j=0;j<100000;j++);
        System.out.print("2...");
        for(i=-10000;i<50000;i++)
            for(k=-100000;k<50000;k++)
                for(j=0;j<100000;j++);
        System.out.print("1...");
        for(i=-10000;i<50000;i++)
            for(k=-100000;k<50000;k++)
                for(j=0;j<100000;j++);
        System.out.print("\f");
    }

    boolean check_space()
    {
        int i=0,j=0;
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
                if(ar[i][j]==0)
                    break;
            if(j!=n)
                break;
        }
        if(i!=n || j!=n)
            return false;
        for(i=0;i<n;i++)
        {
            for(j=1;j<n;j++)
            {
                if(ar[i][j-1]==ar[i][j])
                    break;
                if(ar[j-1][i]==ar[j][i])
                    break;
            }
        }
        if(i!=n || j!=n)
            return false;
        return true;
    } 

    void shift_left()
    {
        int i,j,a,k,z=0;
        for(i=0;i<n;i++) //shifting pt1
        {
            for(j=1;j<n;j++)
            {
                for(k=j;k>0;k--)
                {
                    if(ar[i][k-1]!=0 || ar[i][k]==0)
                        break;
                    ar[i][k-1]=ar[i][k];
                    ar[i][k]=0;
                    if(z==0)
                        z++;
                }
            }
        }
        for(i=0;i<n;i++) //adding
        {
            for(j=1;j<n;j++)
            {
                if(ar[i][j-1]!=ar[i][j])
                    continue;
                ar[i][j-1]=ar[i][j]*2;
                s+=ar[i][j-1];
                ar[i][j]=0;
            }
        }
        for(i=0;i<n;i++) //shifting pt2
        {
            for(j=1;j<n;j++)
            {
                for(k=j;k>0;k--)
                {
                    if(ar[i][k-1]!=0 || ar[i][k]==0)
                        break;
                    ar[i][k-1]=ar[i][k];
                    ar[i][k]=0;
                    if(z==0)
                        z++;
                }
            }
        }
        if(z!=0)
        {
            i=(int)(2*Math.random());
            j=(int)(2*Math.random());
            if(j==0)
                a=2;
            else
                a=4;
        }
        else
        {
            a=0;
        }
        if(i==0)
        {
            for(i=0;i<n;i++)
                if(ar[i][n-1]==0)
                {
                    ar[i][n-1]=a;
                    break;
                }
        }
        else
        {
            for(i=n-1;i>0;i--)
                if(ar[i][n-1]==0)
                {
                    ar[i][n-1]=a;
                    break;
                }
        }
    }

    void shift_right()
    {
        int i,j,a,k,z=0;
        for(i=n-1;i>=0;i--) //shifting pt1
        {
            for(j=n-2;j>=0;j--)
            {
                for(k=j;k<n-1;k++)
                {
                    if(ar[i][k+1]!=0 || ar[i][k]==0)
                        break;
                    ar[i][k+1]=ar[i][k];
                    ar[i][k]=0;
                    if(z==0)
                        z++;
                }
            }
        }
        for(i=n-1;i>=0;i--) //adding
        {
            for(j=n-2;j>=0;j--)
            {
                if(ar[i][j+1]!=ar[i][j])
                    continue;
                ar[i][j+1]=ar[i][j]*2;
                s+=ar[i][j+1];
                ar[i][j]=0;
            }
        }
        for(i=n-1;i>=0;i--) //shifting pt2
        {
            for(j=n-2;j>=0;j--)
            {
                for(k=j;k<n-1;k++)
                {
                    if(ar[i][k+1]!=0 || ar[i][k]==0)
                        break;
                    ar[i][k+1]=ar[i][k];
                    ar[i][k]=0;
                    if(z==0)
                        z++;
                }
            }
        }
        if(z!=0)
        {
            i=(int)(2*Math.random());
            j=(int)(2*Math.random());
            if(j==0)
                a=2;
            else
                a=4;
        }
        else
        {
            a=0;
        }
        if(i==0)
        {
            for(i=0;i<n;i++)
                if(ar[i][0]==0)
                {
                    ar[i][0]=a;
                    break;
                }
        }
        else
        {
            for(i=n-1;i>0;i--)
                if(ar[i][0]==0)
                {
                    ar[i][0]=a;
                    break;
                }
        }
    }

    void shift_up()
    {
        int i,j,a,k,z=0;
        for(i=0;i<n;i++) //shifting pt1
        {
            for(j=1;j<n;j++)
            {
                for(k=j;k>0;k--)
                {
                    if(ar[k-1][i]!=0 || ar[k][i]==0)
                        break;
                    ar[k-1][i]=ar[k][i];
                    ar[k][i]=0;
                    if(z==0)
                        z++;
                }
            }
        }
        for(i=0;i<n;i++) //adding
        {
            for(j=1;j<n;j++)
            {
                if(ar[j-1][i]!=ar[j][i])
                    continue;
                ar[j-1][i]=ar[j][i]*2;
                s+=ar[j-1][i];
                ar[j][i]=0;
            }
        }
        for(i=0;i<n;i++) //shifting pt2
        {
            for(j=1;j<n;j++)
            {
                for(k=j;k>0;k--)
                {
                    if(ar[k-1][i]!=0 || ar[k][i]==0)
                        break;
                    ar[k-1][i]=ar[k][i];
                    ar[k][i]=0;
                    if(z==0)
                        z++;
                }
            }
        }
        if(z!=0)
        {
            i=(int)(2*Math.random());
            j=(int)(2*Math.random());
            if(j==0)
                a=2;
            else
                a=4;
        }
        else
        {
            a=0;
        }
        if(i==0)
        {
            for(i=0;i<n;i++)
                if(ar[n-1][i]==0)
                {
                    ar[n-1][i]=a;
                    break;
                }
        }
        else
        {
            for(i=n-1;i>0;i--)
                if(ar[n-1][i]==0)
                {
                    ar[n-1][i]=a;
                    break;
                }
        }
    }

    void shift_down()
    {
        int i,j,a,k,z=0;
        for(i=n-1;i>=0;i--) //shifting pt1
        {
            for(j=n-2;j>=0;j--)
            {
                for(k=j;k<n-1;k++)
                {
                    if(ar[k+1][i]!=0 || ar[k][i]==0)
                        break;
                    ar[k+1][i]=ar[k][i];
                    ar[k][i]=0;
                    if(z==0)
                        z++;
                }
            }
        }
        for(i=n-1;i>=0;i--) //adding
        {
            for(j=n-2;j>=0;j--)
            {
                if(ar[j+1][i]!=ar[j][i])
                    continue;
                ar[j+1][i]=ar[j][i]*2;
                s+=ar[j+1][i];
                ar[j][i]=0;
            }
        }
        for(i=n-1;i>=0;i--) //shifting pt2
        {
            for(j=n-2;j>=0;j--)
            {
                for(k=j;k<n-1;k++)
                {
                    if(ar[k+1][i]!=0 || ar[k][i]==0)
                        break;
                    ar[k+1][i]=ar[k][i];
                    ar[k][i]=0;
                    if(z==0)
                        z++;
                }
            }
        }
        if(z!=0)
        {
            i=(int)(2*Math.random());
            j=(int)(2*Math.random());
            if(j==0)
                a=2;
            else
                a=4;
        }
        else
        {
            a=0;
        }
        if(i==0)
        {
            for(i=0;i<n;i++)
                if(ar[0][i]==0)
                {
                    ar[0][i]=a;
                    break;
                }
        }
        else
        {
            for(i=n-1;i>0;i--)
                if(ar[0][i]==0)
                {
                    ar[0][i]=a;
                    break;
                }
        }
    }

    public static void main(String args[])
    {
        System.out.print("\f");
        Scanner sc=new Scanner(System.in);
        _2048_game ob= new _2048_game();
        char ch;
        int i,j,a;
        while(true)
        {
            while(true)
            {
                System.out.println("WELCOME TO THE 2048 GAME!\n\nYou want to play in the traditional 4X4 matrix (press T)\n\tOR\nWant to have a custom order of the matrix (press C)?");
                ch=sc.next().charAt(0);
                if(ch=='T' || ch=='C' || ch=='t' || ch=='c')
                    break;
                System.out.println("Guess there was a typing error\n Please retype in");
                ob.time_delay();
            }
            if(ch=='t' || ch=='T')
                i=4;
            else
            {
                System.out.println("Enter the custom order of matrix");
                i=sc.nextInt();
            }
            _2048_game obj= new _2048_game(i);
            a=(int)(i*Math.random());
            j=(int)(i*Math.random());
            obj.ar[a][j]=2;
            System.out.println("READY?");
            ob.time_delay();
            while(true)
            {
                for(i=0;i<obj.n;i++)
                {
                    for(j=0;j<obj.n;j++)
                    {
                        if(obj.ar[i][j]==0)
                            System.out.print("  |\t");
                        else
                            System.out.print(obj.ar[i][j]+" |\t");
                    }
                    System.out.println("\n");
                }
                if(obj.check_space())
                {
                    System.out.println("GAME OVER!");
                    System.out.println("Final Score:"+obj.s);
                    i=-10;
                    break;
                }
                System.out.println("SCORE:"+obj.s+"\nPress:\nU: shift up\tD: shift down\nL: shift left\tR: shift right\nX: restart\tE: exit");
                ch=sc.next().charAt(0);
                ch=Character.toLowerCase(ch);
                if(ch=='u')
                    obj.shift_up();
                else if(ch=='d')
                    obj.shift_down();
                else if(ch=='l')
                    obj.shift_left();
                else if(ch=='r')
                    obj.shift_right();
                else if(ch=='x')
                    break;
                else if(ch=='e')
                    break;
                else
                {
                    System.out.println("Guess there was some typing error\nPlease retry in");
                    ob.time_delay();
                    continue;
                }
                for(i=-10000;i<10000;i++)
                    for(j=0;j<100000;j++);
                System.out.print("\f");
            }
            if(i==-10)
                break;
            if(ch=='e')
            {
                System.out.println("Game exited successfully.");
                break;
            }
            if(ch=='x')
            {
                System.out.println("GAME RESTARTING IN");
                ob.time_delay();
            }
        }
        System.out.println("Thanks for playing!\nHope you enjoyed\nSee ya soon:)");
    }
}
