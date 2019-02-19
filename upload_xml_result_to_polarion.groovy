pipeline {
  agent any
  parameters {
    string( name: 'Test_Product', defaultValue: 'RHEL80', description: 'Optional. Fill in the test product like "RHEL80","RHEL76" which will be put into the polarion test run id. If this filed is empty, it will just use the test run id of the first merged xml.')
    string( name: 'XML_URL_1', defaultValue: '', description: '')
    string( name: 'XML_URL_2', defaultValue: '', description: '')
    string( name: 'XML_URL_3', defaultValue: '', description: '')
    string( name: 'XML_URL_4', defaultValue: '', description: '')
    string( name: 'XML_URL_5', defaultValue: '', description: '')
    string( name: 'XML_URL_6', defaultValue: '', description: '')
    string( name: 'XML_URL_7', defaultValue: '', description: '')
    string( name: 'XML_URL_8', defaultValue: '', description: '')
    string( name: 'XML_URL_9', defaultValue: '', description: '')
    string( name: 'XML_URL_10', defaultValue: '', description: '')
    string( name: 'XML_URL_11', defaultValue: '', description: '')
    string( name: 'XML_URL_12', defaultValue: '', description: '')
    string( name: 'XML_URL_13', defaultValue: '', description: '')
    string( name: 'XML_URL_14', defaultValue: '', description: '')
    string( name: 'XML_URL_15', defaultValue: '', description: '')
    string( name: 'XML_URL_16', defaultValue: '', description: '')
    string( name: 'XML_URL_17', defaultValue: '', description: '')
    string( name: 'XML_URL_18', defaultValue: '', description: '')
  }

  stages {
    stage("Builder") {
      steps {
          sh """rm -rf xml
             mkdir xml
             pushd xml
             xml_url_list="$XML_URL_1 $XML_URL_2 $XML_URL_3 $XML_URL_4 $XML_URL_5 $XML_URL_6 $XML_URL_7 $XML_URL_8 $XML_URL_9 $XML_URL_10 $XML_URL_11 $XML_URL_12 $XML_URL_13 $XML_URL_14 $XML_URL_15 $XML_URL_16 $XML_URL_17 $XML_URL_18"
             for url in $xml_url_list; do
                 wget --no-check-certificate $url
             done
             popd

             python entitlement-tests/merge_polarion_xml_log.py xml/*
             """
      }
    }

  }

}
