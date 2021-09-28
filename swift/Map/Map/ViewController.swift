//
//  ViewController.swift
//  Map
//
//  Created by smyoo on 2021/09/29.
//

import UIKit
import MapKit

class ViewController: UIViewController, CLLocationManagerDelegate {

    @IBOutlet var lblLocationInfo1: UILabel!
    @IBOutlet var lblLocationInfo2: UILabel!
    @IBOutlet var myMap: MKMapView!
    
    let locationManager = CLLocationManager()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lblLocationInfo1.text = ""
        lblLocationInfo2.text = ""
        locationManager.delegate = self
        locationManager.desiredAccuracy = kCLLocationAccuracyBest
        locationManager.requestWhenInUseAuthorization()
        locationManager.startUpdatingLocation()
        myMap.showsUserLocation = true

    }
    
    func goLocation(latitudValue: CLLocationDegrees,
                    longitudeValue: CLLocationDegrees, delta span:Double) {
        let pLocation = CLLocationCoordinate2DMake(latitudValue, longitudeValue)
        let spanValue = MKCoordinateSpan(latitudeDelta: span, longitudeDelta: span)
        let pRegion = MKCoordinateRegion(center:pLocation, span : spanValue)
        
        myMap.setRegion(pRegion, animated: true)
    }

    func locationManger(_ manager:CLLocationManager, didUpdateLocations locations:[CLLocation]) {
        let pLocation = locations.last
        goLocation(latitudValue: (pLocation?.coordinate.latitude)!, longitudeValue: (pLocation?.coordinate.longitude)! , delta: 0.01)
        CLGeocoder().reverseGeocodeLocation(pLocation!, completionHandler: {
            (placemarks, error) -> Void in
            let pm = placemarks!.first
            let country = pm!.country
            var address:String = country!
            if pm!.locality != nil{
                address += " "
                address += pm!.locality!
            }
            if pm!.thoroughfare != nil{
                address += " "
                address += pm!.thoroughfare!
            }
            
            self.lblLocationInfo1.text = "현재 위치"
            self.lblLocationInfo2.text = address
        })
        
        locationManager.startUpdatingLocation()
    }
    
    @IBAction func sgChangeLocation(_ sender: UISegmentedControl) {
    }
    
}

