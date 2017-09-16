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
        "CardTransactionsList": card_info['transactions']
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


cards_info = None
with open('cards_info.pkl', 'rb') as handle:
    cards_info = pickle.load(handle)

app.run(host='0.0.0.0', debug=True, port=6006)
