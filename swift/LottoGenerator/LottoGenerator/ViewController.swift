//
//  ViewController.swift
//  LottoGenerator
//
//  Created by zepetto on 2021/10/04.
//

import UIKit

class ViewController: UIViewController {
    

    @IBOutlet weak var lblNumberArea: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func runBtn(_ sender: UIButton) {
        var numbers:[Int] = [] //담아둘 배열
        var result = ""

        while numbers.count < 6 {
            let number = Int.random(in: 1...45)
            if !numbers.contains(number){
                numbers.append(number)
                result.append(String(number) + " ")
            }
        }
        
        lblNumberArea.text = result
    }
}

