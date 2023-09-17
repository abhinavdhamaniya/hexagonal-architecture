package com.hexagonalArchitecture

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@Target(AnnotationTarget.CLASS)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
annotation class AutoConfigureTest()
