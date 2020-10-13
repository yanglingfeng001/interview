#include <iostream>
#include <fstream>
#include <vector>
#include <map>
#include <set>
#include<stdlib.h>
using namespace std;
typedef struct kv
{
    int index;
    int min;
}kv;
int isSub(string str,string substr);
int hashcode(string data,int base);
vector<int> kgram(string data,int k);
kv minarray(int data[],int n);
bool compare(kv k1,kv k2);
map<int,int> winnowing(vector<int> hashnumber,int w);
double comparemap(map<int,int>a,map<int,int> b);
map<int,int> getdata(string data);
string getfiledata(string filename);
double comparefile(string data1,string data2);
string getfilename(string data);
int isSub(string str,string substr)//2是不是1的子串,是返回位置，不是返回-1
{
    
    for(int i=0;i<str.length();i++)
    {
        bool ok=false;
        if(substr[0]==str[i])
        {
            ok=true;
            
            for(int j=0;j<substr.length();j++)
            {
                if(substr[j]!=str[i+j]){ok=false;
                }//只要有一个字符不相同
            }
            if(ok==true)//如果所有字符都相同
            {return i;}
        }
    }
    return -1;
}
int hashcode(string data,int base)//基数为base，使用公式c1∗bk−1+c2∗bk−2+....+ck−1∗b+ck，计算输入字符串的哈希值
{
    int result=0;
    for(string::iterator it=data.begin();it!=data.end();++it)
    {
        result=(result*base)+ *it;
    }
    return result;
}
vector<int> kgram(string data,int k)//传入数据data，分解成k-gram,并返回哈希值数组
{
    vector<int> gram;
    for(int i=0;i<data.size();i++)
    {
        if(i+k<=data.size())
        {
            gram.push_back(hashcode(data.substr(i,k),3));
        }
        
    }
    
    return gram;
}
kv minarray(int data[],int n)//排序求vector中最小值以及位置信息,从0开始
{
    int j;
    kv newkv;
    int min=data[n-1];
    newkv.min=min;
    int index=n-1;
    newkv.index=index;
    for(j=n-1;j>=0;j--)
    {
        if(min>data[j])
        {
            newkv.min=data[j];
            newkv.index=j;
        }
    }
    return newkv;
}
bool compare(kv k1,kv k2)
{
    if(k1.min==k2.min&&k1.index==k2.index)
        return true;
    else
        return false;
}
map<int,int> winnowing(vector<int> hashnumber,int w)//摘取特征值，这里除了摘取窗口中的最小值外，还记录了作为特征值的 Hash 值在原 Hash 序列中的位置,w为窗口的大小
{  //假设我们希望任意t个字符之内（不包含t）的重复都能被查出来，那么我们就设置一个窗口（window)w=t-k+1,原则上来说是这样的
    
    map<int, int> mmp;
    kv pre_min,min;
    pre_min.min=-1000;
    pre_min.index=-1000;
    int len=hashnumber.size();
    int h[w];
    for(int i=0;i<=len-w;i++)
    {
        int t=i;
        for(int k=0;k<w;k++)//对窗口数组进行赋值
        {
            int change=hashnumber[k+t];
            h[k]=change;//数组赋值完毕
        }
        min=minarray(h,w);//返回当前数组的最小值k-v序列(但是当前的位置只是相对于h数组，所以应当转化为整个hashnumber数组的)
        min.index+=t;
        if(!compare(min,pre_min))//不相同的话应该是一个全新的特征值
        {
            
            mmp.insert(map<int, int>::value_type(min.index, min.min));
            pre_min = min;
            
        }
        
    }
    return mmp;
}
string hadnledata(string data,int type)//将传入字符串中的标点符号和注释等删除,type:1为c源代码2为shell源代码
{
    
    return data;
}

double comparemap(map<int,int>a,map<int,int> b)//比较特征值序列
{
    double rate=0;
    set<int> s,s2;
    map<int,int>::iterator iter1,iter2;
    iter1=a.begin();
    iter2=b.begin();
    if(a.size()<=b.size()) {//假如a的大小小于等于b的大小
        while(iter2!=b.end())
        {
            bool ok=false;
            for(map<int,int>::iterator iter=a.begin();iter!=a.end();++iter)
            {
                if(iter2->second==iter->second)
                {s.insert(iter->second);
                    ok=true;
                }
            }
            if(ok==false)
            {
                s2.insert(iter2->second);
            }
            
            iter2++;
        }
    }
    else{
        while(iter1!=a.end())
        {
            bool ok=false;
            for(map<int,int>::iterator iter=b.begin();iter!=b.end();++iter)
            {
                if(iter1->second==iter->second)
                {  s.insert(iter->second);
                    ok=true;
                }
                
            }
            if(ok==false)
            {
                s2.insert(iter1->second);
            }
            iter1++;
        }
        
    }
    rate=(s.size()*1.0)/(s.size()+s2.size());
    
    
    
    return rate;
}
map<int,int> getdata(string data)//此步读取字符串的同时处理字符串，分不同情况,c和shell的处理规则不同,文件名和所处流的位置传入
{
            vector<int> hashnumber = kgram(data,6);//！！！data还未删除标点符号等，注释，头文件以及宏也要删除
            map<int,int> mmp;
            mmp=winnowing(hashnumber,6);
            return mmp;
   
}
double comparefile(string data1,string data2)
{
    
    map<int,int> a,b;
    a=getdata(data1);
    b=getdata(data2);
    double rate=comparemap(a,b);
    return rate;
}
string getfiledata(string filename)//从文件名获取并处理数据
{
    int type;
    string data,s;
    ifstream infile;
    if(isSub(filename,".c")!=-1)
    {
        type=1;
    }
    else if(isSub(filename,".sh")!=-1){
        type=2;
    }
    else{

        return "";
            }
    infile.open(filename.c_str());
    if(infile.fail())
    {
        cout<<"Fail to open the input file:"<<filename<<endl;
        return "";
    }
    while (infile) {
        // 在屏幕上写入数据
        infile >>s;
        if (infile.fail())
        {
            break;
        }
        else//此处应该进行判断并进行不同的划分并处理字符串type1为c文件，type2为shell文件
        {
            if(type==1)//c文件!!!!!!!!!!!!!
            {
                if(isSub(s,"//")!=-1)//如果是单行注释的情况
                {data+=(s.substr(0,isSub(s,"//")));
                }
                else if(isSub(s,"/*")!=-1&&isSub(s,"printf")==-1)//如果是多行注释的情况
                {
                    data+=(s.substr(0,isSub(s,"/*")));
                    if(isSub(s,"*/")!=-1)
                    {
                        data+=(s.substr((isSub(s,"*/")+2)));                   }
                    else
                {while(infile)
                    {
                        infile >>s;
                        if (infile.fail())
                        {
                            break;
                        }
                        else{
                            if(isSub(s,"*/")!=-1&&isSub(s,"printf")==-1)
                            {
                                data+=(s.substr((isSub(s,"*/")+2)));
                                break;
                            }
                        }
                    }
                    }
                }
                else
                {data+=s;}
            }
            else//sh文件!!!!!!!!!!!
            {
                if(isSub(s,"#")!=-1)//#开头为shell注释读进来的包含shell注释的情况
                {data+=(s.substr(0,isSub(s,"#")));}
                else
                { data+=s;}
            }
        }
    }
    return data;
}
string getfilename(string data)
{
    unsigned long i=data.size();
    for(;i>0;i--)
    {
        if(data[i]=='/')
        {
            return data.substr(i+1);
        }
    }
    return "";
}
int main(int argc, char *argv[]) {
    string file_list="/Users/coconut/generate_filelist/index.txt";
    string s;
    int number1=0;//c文件的数组大小
    int number2=0;//shell文件的数组大小
    string cfilename[205];//c文件名数组
    string shfilename[205];//shell文件名数组
    string cdata[205];
    string shdata[205];
    ifstream infile;
    infile.open(file_list.c_str());
    if(infile.fail())
    {
        cout<<"Fail to open the input file"<<endl;
        exit(1);
    }
    while (infile) {
        // 在屏幕上写入数据
        infile >> s;
        if (infile.fail())
        {
            break;
        }
        else
        {
            if(isSub(s, ".c")!=-1)
            {
                cfilename[number1]=s;
                number1++;
            }
            else if(isSub(s,".sh")!=-1)
                {shfilename[number2]=s;
                    number2++;

                }
        }
    }//读取文件整个字符串，存储在data中，现在应当进行文件分类并存在两个不同的string数组中，再将文件流赋值
        cout<<"读取文件开始"<<endl;
    for(int i=0;i<number1;i++)
    {
        if(getfiledata(cfilename[i]).size()!=0)
        cdata[i]=getfiledata(cfilename[i]);
        
    }
    for(int i=0;i<number2;i++)
    { if(getfiledata(shfilename[i]).size()!=0)
        shdata[i]=getfiledata(shfilename[i]);
    }
        cout<<"读取文件结束"<<endl;
    cout<<"c文件比价开始"<<endl;
    for(int i=0;i<number1;i++)
    {
        for(int j=i+1;j<number1;j++)
        {
            double rate=comparefile(cdata[i],cdata[j]);
            cout<<getfilename(cfilename[i])<<"和"<<getfilename(cfilename[j])<<"重合率为:"<<rate<<endl;
        }

    }
    cout<<"c文件比价结束"<<endl;
    cout<<"shell文件比价开始"<<endl;
    for(int i=0;i<number2;i++)
    {
        for(int j=i+1;j<number2;j++)
        {
            double rate=comparefile(shdata[i],shdata[j]);
            cout<<getfilename(shfilename[i])<<"和"<<getfilename(shfilename[j])<<"重合率为:"<<rate<<endl;
        }

    }
    cout<<"shell文件比价结束"<<endl;
    return 0;
}
