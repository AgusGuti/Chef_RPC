from app import create_app
from flask import render_template
from argparse import ArgumentParser
from multiprocessing import Pool

app = create_app('flask.cfg')

@app.route("/", methods=["GET"])
def home():    
    
    return render_template('login.html')


if __name__ == '__main__':
    parser = ArgumentParser()
    parser.add_argument('-p', '--port', default=5000, type=int, help='port to listen on')
    args = parser.parse_args()
    port = args.port

    app.run(host='0.0.0.0', port=port)