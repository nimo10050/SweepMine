#include<stdio.h>

int read()
{
    int coinCount = 0;
    scanf("%d", &coinCount);
    return coinCount;
}

void magic(int coinCount)
{
    if(coinCount<=0)
    {
        return;
    }
    if(coinCount%2==0)
    {
        coinCount = (coinCount - 2)/2;
        magic(coinCount);
        putchar('2');
    }
    else {
        coinCount = (coinCount - 1)/2;
        magic(coinCount);
        putchar('1');
    }
  
}

int main()
{
	int coinCount = read();
    magic(coinCount);
    return 0;
}
