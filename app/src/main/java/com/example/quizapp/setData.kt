package com.example.quizapp

object setData {

    const val name:String = "name"
    const val score:String = "score"

    fun getQuestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()
        var question1 = QuestionData(
            1,
            "¿Qué altura tiene la Estatua de Cristo Redentor (Brasil)?",

            "35 metros",
            "30 metros",
            "25 metros",
            "40 metros",
            2
        )
        var question2 = QuestionData(
            2,
            "¿En el reinado de qué emperador inca se construyo el Machu Picchu (Perú)?",

            "Pachacútec",
            "Huáscar",
            "Mayta Cápac",
            "Túpac Inca Yupanqui",
            1
        )
        var question3 = QuestionData(
            3,
            "¿Qué longitud aproximada tiene La Gran Muralla China (China)?",

            "26.500 kilómetros",
            "22.200 kilómetros",
            "19.400 kilómetros",
            "32.800 kilómetros",
            2
        )
        var question4 = QuestionData(
            4,
            "¿En qué país se encuentra la Ciudad de Petra (...)?",

            "Israel",
            "Irak",
            "Jordania",
            "Líbano",
            3
        )

        var question5 = QuestionData(
            5,
            "¿Entre qué años fue construido el Taj Mahal (India)?",

            "1605-1617",
            "1622-1640",
            "1613-1638",
            "1631-1653",
            4
        )

        var question6 = QuestionData(
            6,
            "¿Qué capacidad tenía el Coliseo Romano (Italia)?",

            "Entre 50.000 y 70.000 espectadores",
            "Entre 40.000 y 60.000 espectadores",
            "Entre 60.000 y 80.000 espectadores",
            "Entre 70.000 y 90.000 espectadores",
            1
        )

        var question7 = QuestionData(
            7,
            "¿En honor a qué dios fue eregido el edificio principal de Chichén Itzá (México)?",

            "ITZAMNÁ",
            "CHAAC",
            "KINICH AHAU",
            "KUKULCÁN",
            4
        )

        que.add(question1)
        que.add(question2)
        que.add(question3)
        que.add(question4)
        que.add(question5)
        que.add(question6)
        que.add(question7)
        return que
    }
}