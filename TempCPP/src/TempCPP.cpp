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

        int middle = (high - low) / 2 + low; // ֱ��ʹ��(high + low) / 2 ���ܵ������
        cout << "curr: " << a[middle] << " " << middle << endl;
        if (a[middle] == goal)
            return middle;
        //������
        else if (a[middle] > goal)
            high = middle - 1;
        //���Ұ��
        else
            low = middle + 1;
    }
    //û�ҵ�
    return -1;
}
int main()
{
	cout << sizeof(hehe);
	cout << sizeof(long);
	cout << sizeof(double);
	return 0;
}

