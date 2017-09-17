from flask import Flask
import pickle
import json
from flask_cors import CORS, cross_origin
from flask import request
app = Flask(__name__)
cors = CORS(app)


@app.route("/MyCards/1.0.0/MyCards/balance", methods=['POST'])
def get_balance():
    number = json.loads(request.data)['CardId']
    card_info = cards_info[number]
    balance = card_info['balance']
    cur = card_info['cur']
    ans = {
        'ErrorCode': '0',
        'CardId': str(number),
        'CardBalance': [{'Cur': cur, 'Value': balance}]
    }
    return json.dumps(ans)

@app.route("/MyCards/1.0.0/MyCardsInfo/history", methods=['POST'])
def get_card_history():
    number = json.loads(request.data)['CardId']
    card_info = cards_info[number]
    anw = {
        "ErrorCode": "0",
        "CardId": str(number),
        "CardTransactionsList": card_info['transactions'][:1000]
    }
    return json.dumps(anw)

@app.route("/MySubscribtions/1.0.0/list", methods=['POST'])
def get_subscribtions():
    number = json.loads(request.data)['CardId']
    card_info = cards_info[number]
    anw = {
        "ErrorCode": "0",
        "CardId": str(number),
        "CardSubscribtionsList": card_info['subscribtions']
    }
    return json.dumps(anw)

@app.route("/MySubscribtions/1.0.0/set", methods=['POST'])
def set_details():
    data = json.loads(request.data)
    number = data['CardId']
    subs_id = data['subs_id']
    card_info = cards_info[number]
    count_cnaged_elements = 0
    for key in data:
        if key in ['max_cost', 'active', 'stars']:
            card_info['subscribtions'][subs_id][key] = data[key]
        elif key == 'comment':
            print(card_info['subscribtions'][subs_id].keys())
            card_info['subscribtions'][subs_id]['comments'].append(
                data[key]
            )
        else:
            continue
        count_cnaged_elements += 1
    anw = {
        "ErrorCode": "0",
        "CardId": str(number),
        "ElementsChanged": count_cnaged_elements,
        "CardSubscribtionDetailsById": cards_info[number]['subscribtions'][subs_id]
    }
    return json.dumps(anw)


@app.route("/MySubscribtions/1.0.0/getById", methods=['POST'])
def get_sub_by_id():
    data = json.loads(request.data)
    number = int(data['CardId'])
    subs_id = int(data['subs_id'])
    sub_info =  cards_info[number]['subscribtions'][subs_id]
    sub_info['total_payed'] = sub_info['first_payment'] * sub_info['live_time_months']
    anw = {
        "ErrorCode": "0",
        "CardId": str(number),
        "CardSubscribtionDetailsById": sub_info,
    }
    return json.dumps(anw)

@app.route("/MyCards/1.0.0/list", methods=['GET'])
def get_all_cards():
    anw = {
        "ErrorCode": "0",
        "MyCardsList": [
            {
                "CardId": i,
                "CardName": "Семейная карта",
                "CardPaymentSystem": "master",
                "CardType": "debit",
            } for i in cards_info.keys()
        ]
    }
    return json.dumps(anw)


cards_info = None
with open('cards_info.pkl', 'rb') as handle:
    cards_info = pickle.load(handle)

app.run(host='0.0.0.0', debug=True, port=6006)
