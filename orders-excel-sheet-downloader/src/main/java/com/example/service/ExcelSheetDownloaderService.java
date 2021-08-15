package com.example.service;

import java.io.ByteArrayInputStream;

import org.springframework.stereotype.Service;

@Service
public interface ExcelSheetDownloaderService {

	public ByteArrayInputStream getOrdersSheet();

}
