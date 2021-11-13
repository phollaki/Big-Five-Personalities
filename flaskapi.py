from flask import Flask, json, request
import numpy as np
import pandas as pd
from sklearn.preprocessing import LabelEncoder
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import confusion_matrix, accuracy_score
api = Flask(__name__)

@api.route('/running', methods=['GET'])
def get_activity():
  x = "server is running"
  return x
  
@api.route('/personality', methods=['POST'])
def get_personality():
  print("Calculating personality . . .")
  answ1 = int(request.form.get('answ0'))
  answ2 = int(request.form.get('answ1'))
  answ3 = int(request.form.get('answ2'))
  answ4 = int(request.form.get('answ3'))
  answ5 = int(request.form.get('answ4'))
  answ6 = int(request.form.get('answ5'))
  answ7 = int(request.form.get('answ6'))
  answ8 = int(request.form.get('answ7'))
  answ9 = int(request.form.get('answ8'))
  answ10 = int(request.form.get('answ9'))
  answ11 = int(request.form.get('answ10'))
  answ12 = int(request.form.get('answ11'))
  answ13 = int(request.form.get('answ12'))
  answ14 = int(request.form.get('answ13'))
  answ15 = int(request.form.get('answ14'))
  answ16 = int(request.form.get('answ15'))
  answ17 = int(request.form.get('answ16'))
  answ18 = int(request.form.get('answ17'))
  answ19 = int(request.form.get('answ18'))
  answ20 = int(request.form.get('answ19'))
  age = int(request.form.get('age'))
  gender = int(request.form.get('gender'))
  density = int(request.form.get('density'))
  avg_temp = int(request.form.get('avg_temp'))
  individualism_score = int(request.form.get('invi_score'))
  gp_avg = int(request.form.get('gp_avg'))
  dataset = pd.read_csv('./Bigfive15000.csv')
  X = dataset.iloc[:, :-1].values
  y = dataset.iloc[:, -1].values
  #le = LabelEncoder()
  #y = le.fit_transform(y)
  X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2)
  sc = StandardScaler()
  X_train = sc.fit_transform(X_train)
  X_test = sc.transform(X_test)
  classifier = LogisticRegression()
  classifier.fit(X_train, y_train)
  predicted = classifier.predict(sc.transform([[answ1,answ2,answ3,answ4,answ5,answ6,answ7,answ8,answ9,answ10,answ11,answ12,answ13,answ14,answ15,answ16,answ17,answ18,answ19,answ20,age,gender,density,avg_temp,individualism_score,gp_avg]]))
  print(predicted)
  return predicted[0]

if __name__ == '__main__':
    api.run() 
    