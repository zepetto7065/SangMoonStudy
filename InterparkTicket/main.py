from selenium import webdriver
from selenium.webdriver import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager


def set_chrome_driver():
    chrome_options = webdriver.ChromeOptions()
    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()),options=chrome_options)
    return driver


driver = set_chrome_driver()


#사이즈 조절
driver.set_window_size(1400,1000)
driver.get('https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com')

#로그인
# driver.switch_to.frame(driver.find_element(By.XPATH,"//div[@class='leftLoginBox']/iframe[@title='login']"))
# driver.switch_to.frame(driver.find_element(By.XPATH,"//div[@class='leftLoginBox']/iframe[@title='login']"))
userId = driver.find_element(By.ID, 'id')
userId.send_keys('adioson')
userPwd = driver.find_element(By.ID,'pw')
userPwd.send_keys('033123dd')
userPwd.send_keys(Keys.ENTER)