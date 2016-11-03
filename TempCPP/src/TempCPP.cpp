//============================================================================
// Name        : TempCPP.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
#include<CString>
#include<stdio.h>
using namespace std;
struct hehe
{
	int a;
	char b;
	short c;
};
int binary_search(int* a, int len, int goal)
{
    int low = 0;
    int high = len -1;
    while (low <= high)
    {

        int middle = (high - low) / 2 + low; // 直接使用(high + low) / 2 可能导致溢出
        cout << "curr: " << a[middle] << " " << middle << endl;
        if (a[middle] == goal)
            return middle;
        //在左半边
        else if (a[middle] > goal)
            high = middle - 1;
        //在右半边
        else
            low = middle + 1;
    }
    //没找到
    return -1;
}
static int a;
int main()
{
	static int b;
	//int a = 0xf8000000;
//	unsigned int b = 0x78000000;
	//a>>=1;
	//b>>=1;
	printf("%8d, %8d", a,b);

	return 0;
}

