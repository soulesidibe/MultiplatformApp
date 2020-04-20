//
//  ContentView.swift
//  MultiplatformIOS
//
//  Created by Souleymane Sidibe on 4/18/20.
//  Copyright © 2020 Souleymane Sidibe. All rights reserved.
//

import SwiftUI
import SharedCode

struct ContentView: View {
    @State var text = "Hello!"
    var body: some View {
        Text(text)
            .onAppear {
                self.getRandomNumer()
        }
    }
    func getRandomNumer() {
        let status = Reach().connectionStatus()
        
        switch status {
        case .online(.wiFi), .online(.wwan):
             CommonKt.getRandomNumber(response: { (text: String) in
                       self.text = text
             }, error: { (message: String, code: KotlinInt) in
                
             })
        default:
            print("Not connected")
}
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}


