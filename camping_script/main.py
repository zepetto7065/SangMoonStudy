import requests
import time


def get_availability(stay_date):
    shop_encode = '5f9422e223671b122a7f2c94f4e15c6f71cd1a49141314cf19adccb98162b5b0'
    shop_code = '212820734901'

    s = requests.Session()
    r = s.get("https://camp.xticket.kr/web/main?shopEncode=" + shop_encode)

    product_codes = ['0001', '0002', '0003']

    url = "https://camp.xticket.kr/Web/Book/GetBookProduct010001.json"

    available_tents = []
    for product_code in product_codes:
        params = {'product_group_code': product_code,
                  'start_date': stay_date,
                  'end_date': stay_date,
                  'book_date': 1,
                  'two_stay_days': 0,
                  'shopCode': shop_code}
        response = s.post(url, params)
        json_data = response.json()
        for tent in json_data["data"]["bookProductList"]:
            if tent['status_code'] == '0' and int(tent['sale_product_fee']) > 0:
                available_tents.append(tent['product_name'])
    return available_tents


if __name__ == '__main__':
    check_dates = ['20220601', '20220604', '20220605', '20220606',
                   '20220611', '20220612',
                   '20220618',
                   '20220625', '20220626']

    while True:
        for check_date in check_dates:
            tents = get_availability(check_date)
            if len(tents) > 0:
                print(check_date + " : " + ' , '.join(tents))
            else:
                print(check_date + " : None")
            time.sleep(1)
        print("----------------------")
        time.sleep(5)