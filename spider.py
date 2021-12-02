# -*- coding = utf-8 -*-
# @Time : 2021/11/23 22:37
# @Author : 李俊池
# @File : spider.py
# @Software : PyCharm

import json
import requests



def main(null=None):
    wd = input("输入搜索内容")
    #获得全部数据
    response = askURLbyPOST(wd)
    # 抓取所需数据
    datalist = getDatea(response)


#请求网页并返回数据
def askURLbyPOST(wd):
    head = {
        "groupCode": "200069",
        "Referer": "https://findcumt.libsp.com/",
        "Content-Type": "application/json",
        "Cookie": "SameSite=None",
        "User - Agent":"Mozilla / 5.0(Windows NT 10.0;Win64;x64) AppleWebKit / 537.36(KHTML, likeGecko) Chrome / 96.0.4664.55Safari / 537.36Edg / 96.0.1054.34"
    }
    url = "https://findcumt.libsp.com/find/unify/search"
    data = {
        "searchFieldContent": wd,
        "searchField": "keyWord"
    }
    res = requests.post(url=url, json=data, headers=head)
    text=res.content.decode()
    return json.loads(text)



#将数据装入表内
def getDatea(response):
    data=response["data"]["searchResult"]
    for item in range(len(data)):
        datalist=[]
        datalist.append(data[item]["recordId"])
        datalist.append(data[item]["title"])
        datalist.append(data[item]["publisher"])
        datalist.append(data[item]["isbn"])
        datalist.append(getInformation(data[item]["recordId"]))#获得馆藏信息并存入datalist中
        print(datalist)
    return datalist





#获得馆藏信息
def getInformation(id):
    url="https://findcumt.libsp.com/find/physical/groupitems"
    head = {
        "groupCode": "200069",
        "Referer": "https://findcumt.libsp.com/",
        "Cookie": "SameSite=None",
        "User - Agent": "Mozilla / 5.0(Windows NT 10.0;Win64;x64) AppleWebKit / 537.36(KHTML, likeGecko) Chrome / 96.0.4664.55Safari / 537.36Edg / 96.0.1054.34"
    }

    data = {
        "page":"1",
        "recordId":id,
        "rows":20
    }
    response = requests.post(url,json=data,headers=head)
    response = response.content.decode()
    text = json.loads(response)
    data = text["data"]
    for item in range(len(data)):
        datalist=[]
        datalist.append(data[item]["barcode"])
        datalist.append(data[item]["locationName"])
        datalist.append(data[item]["processType"])
        return datalist

if __name__ == "__main__":
    main()