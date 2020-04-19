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
        CommonKt.getRandomNumber(response: { (text: String) in
            self.text = text
        })
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
