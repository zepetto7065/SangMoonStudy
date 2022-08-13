//
//  ViewController.swift
//  HelloWorld
//
//  Created by smyoo on 2021/09/28.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet var lblHello: UILabel! //출력 레이블용 아웃렛 변수
    @IBOutlet var txtName: UITextField! //이름 입력용 아웃렛 변수
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnSend(_ sender: UIButton) {
        //action 함수
        lblHello.text = "Hello, " + txtName.text!
    }
    
}

