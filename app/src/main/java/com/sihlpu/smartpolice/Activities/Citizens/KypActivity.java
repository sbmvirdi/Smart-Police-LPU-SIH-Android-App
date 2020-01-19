package com.sihlpu.smartpolice.Activities.Citizens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.sihlpu.smartpolice.Adapters.KypAdapter;
import com.sihlpu.smartpolice.R;

import java.util.ArrayList;
import java.util.List;

public class KypActivity extends AppCompatActivity {
    private Spinner district_spinner;
    private ListView ls;
    private KypAdapter adapter;
    private ArrayList<policestation> arrayList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kyp);

        district_spinner = findViewById(R.id.district_spinner);
        List<String> districts = new ArrayList<>();
        districts.add(" AMRITSAR – CITY");
        districts.add(" AMRITSAR – RURAL");
        districts.add(" BARNALA");
        districts.add(" BATALA");
        districts.add(" BATHINDA");
        districts.add(" FARIDKOT");
        districts.add(" FAZILKA");
        districts.add(" FEROZEPUR");


        ls=findViewById(R.id.policeList);
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Div. A","ps..diva.asr.police@punjab.gov.in","Md Ayub","11","2","97811-30201"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Div. B","ps.divb.asr.police@punjab.gov.in","Samrat Deepak","7","2","97811-30202"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Div. C","ps.divc.asr.police@punjab.gov.in","Ajeet Kumar Shriwastav","5","1","97811-30203"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Div. D","ps.divd.asr.police@punjab.gov.in","Harendra Prasad","6","1","97811-30204"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Div. E","ps.dive.asr.police@punjab.gov.in","Vrendra Kumar Singh","12","1","97811-30205"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Civil Lines","ps.cvllns.asr.police@punjab.gov.in","Rajesh Kumar","5","1","97811-30208"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Sadar","ps.sdr.asr.police@punjab.gov.in","Suresh Kumar","6","2","97811-30209"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Islamabad","ps.islmbd.asr.police@punjab.gov.in","Sunil Kumar","6","2","97811-30210"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Chheharta","ps.chrta.asr.police@punjab.gov.in","Lalbabu Prasad","6","1","97811-30211"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Sultanwind","ps.sltwnd.asr.police@punjab.gov.in","Subhash Mukhiya","10","2","97811-30206"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Gate Hakiman","ps.gath.asr.police@punjab.gov.in","Dushyant Kumar","10","2","97811-30226"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Cantonment","ps.ctmt.asr.police@punjab.gov.in","Shyamsundar Prasad","9","2","97811-30237"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Maqboolpura","ps.mqlpr.asr.police@punjab.gov.in","NITYANAND CHAUHAN","12","2","97811-30218"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Women","ps.wmn.asr.police@punjab.gov.in","MANISH SHARMA","11","2","97811-30320"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS NRI","ps.nri.asr.police@punjab.gov.in","RAMESH CHANDRA UPADAYAY","8","1","98786-07717"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – CITY","PS Airport","ps.arprt.asr.police@punjab.gov.in","SANTOSH KUMAR","6","2","97811-30221"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Jandiala Guru","ps.jdgrasrr.police@punjab.gov.in","RAMESH CHANDRA UPADAYAY","10","2","97800-11443"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Beas","ps.beasasr.police@punjab.gov.in","RAJESH JHA","11","1","97800-11467"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Mehta","ps.mhtasrr.police@punjab.gov.in","MUKESH VERMA","11","2","97800-11458"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Lopoke","ps.lpk.asrr.police@punjab.gov.in","RAFUKUR RAHMAN","10","1","97800-11368"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Ajnala","ps.ajnlasrr.police@punjab.gov.in","OM PRAKASH CHAUHAN","11","1","97800-11074"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Ramdass","ps.rmdsasrr.police@punjab.gov.in","KISHOR KUMAR","9","1","97800-11097"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Kathu Nangal","ps.ktl.asrr.police@punjab.gov.in","VIVEK KUMAR JAISWAL","10","1","97800-11023"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Majitha","ps.mjt.asrr.police@punjab.gov.in","RAJMANI","5","1","97800-11014"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Mattewal","ps.mtl.asrr.police@punjab.gov.in","RATNESH KUMAR VERMA","9","2","97800-11024"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Jhander","ps.jdr.asrr.police@punjab.gov.in","KUNDAN KUMAR SINGH","10","1","97800-11268"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Khilchian","ps.khlc.asrr.police@punjab.gov.in","SURAJ PRASAD","6","2","97800-11459"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Gharinda","ps.gnd.asrr.police@punjab.gov.in","VIJAY KUMAR YADAV","12","2","97800-11468"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Rajasansi","ps.rjs.asrr.police@punjab.gov.in","SHAHID ANWAR","7","2","97800-11356"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Bhindi Saidan","ps.bhsn.asrr.police@punjab.gov.in","CHADRASHEKHAR GUPTA","6","2","97800-11359"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Tarsikka","ps.trsk.asrr.police@punjab.gov.in","AWADHESH JHA","5","1","97800-11457"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Chattiwind","ps.ctwd.asrr.police@punjab.gov.in","RANVEER JHA","6","1","97800-11478"));
        arrayList.add(new policestation("Punjab"," AMRITSAR – RURAL","PS Kamboj","ps.kbj.asrr.police@punjab.gov.in","KRISHNA MURARI GUPTA","5","1","97800-11469"));
        arrayList.add(new policestation("Punjab"," BARNALA","PS Sehna","ps.sehna.brn.police@punjab.gov.in","RAM BINOD KUMAR SINGH","7","1","75081-79020"));
        arrayList.add(new policestation("Punjab"," BARNALA","PS Tappa","ps.tappa.brn.police@punjab.gov.in","ARAVINDRA KUMAR","9","2","75081-79018"));
        arrayList.add(new policestation("Punjab"," BARNALA","PS Dhanaula","ps.dhnola.brn.police@punjab.gov.in","AMRENDRA KUMAR","7","2","75081-79016"));
        arrayList.add(new policestation("Punjab"," BARNALA","PS Thuliwall","ps.thwl.brn.police@punjab.gov.in","MUKESH KUAMR","12","2","75081-79028"));
        arrayList.add(new policestation("Punjab"," BARNALA","PS Rureke Kalan","ps.rkkl.brn.police@punjab.gov.in","SIKANDAR KUMAR","7","1","75081-79019"));
        arrayList.add(new policestation("Punjab"," BARNALA","PS Tallewal","ps.tlwl.brn.police@punjab.gov.in","CHANDRABHUSHAN SINGH","7","2","75081-79026"));
        arrayList.add(new policestation("Punjab"," BARNALA","PS Barnala","ps.sdr.brn.police@punjab.gov.in","BIMLENDU KUMAR","8","2","75081-79015"));
        arrayList.add(new policestation("Punjab"," BARNALA","PS City","ps.cty.brn.police@punjab.gov.in","SHAMIM AKHTAR HAWARI","12","1","75081-79014"));
        arrayList.add(new policestation("Punjab"," BARNALA","PS Mahil Kalan","ps.mhlkln.brn.police@punjab.gov.in","Mrityunjay Kumar Mishra","9","1","75081-79023"));
        arrayList.add(new policestation("Punjab"," BATALA","PS City","ps.cty.btl.police@punjab.gov.in","Anshu Kumar jha","11","2","91156-14101"));
        arrayList.add(new policestation("Punjab"," BATALA","PS Sadar","ps.sdr.btl.police@punjab.gov.in","Suyog Gotad","5","1","91156-14102"));
        arrayList.add(new policestation("Punjab"," BATALA","PS Dera Baba Nanak","ps.drbnnk.btl.police@punjab.gov.in","Ashutosh Kumar","8","1","91156-14106"));
        arrayList.add(new policestation("Punjab"," BATALA","PS F.G.Churiana","ps.ftgchn.btl.police@punjab.gov.in","Prashant Pandey","10","2","91156-14105"));
        arrayList.add(new policestation("Punjab"," BATALA","PS Ghanie Ke Bangar","ps.ghkbgr.btl.police@punjab.gov.in","Pulkit Bajpai","11","2","91156-14104"));
        arrayList.add(new policestation("Punjab"," BATALA","PS Qadian","ps.qadian.btl.police@punjab.gov.in","Sai Ram Ponnaganti","10","1","91156-14110"));
        arrayList.add(new policestation("Punjab"," BATALA","PS Rangar Nangal","ps.rngngl.btl.police@punjab.gov.in","Akash Ray","8","2","91156-14113"));
        arrayList.add(new policestation("Punjab"," BATALA","PS Ghuman","ps.ghuman.btl.police@punjab.gov.in","Ujjwal Kumar Tiwari","5","2","91156-14112"));
        arrayList.add(new policestation("Punjab"," BATALA","PS Sri HarGobindpur","ps.shgpur.btl.police@punjab.gov.in","Shashwat Raj","8","2","91156-14111"));
        arrayList.add(new policestation("Punjab"," BATALA","PS Qila Lal Singh","ps.qlsgh.btl.police@punjab.gov.in","Raashi Sharma","9","2","91156-14108"));
        arrayList.add(new policestation("Punjab"," BATALA","PS Civil Lines","ps.cvlbtl.btl.police@punjab.gov.in","Subrat Katiyar","8","2","91156-14103"));
        arrayList.add(new policestation("Punjab"," BATALA","PS Kotli Surat Mallian","ps.ktsrml.btl.police@punjab.gov.in","Ashutosh Kumar","9","1","91156-14107"));
        arrayList.add(new policestation("Punjab"," BATALA","PS Sekhwan","ps.swn.btl.police@punjab.gov.in","Jeetanshu Srivastava","5","1","91156-14109"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Civil Lines","ps.civll.btd.police@punjab.gov.in","Afzal Karim Talukdar","11","1","75080-18102"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Kotwali","ps.ktw.btd.police@punjab.gov.in","M Vishal","11","1","75080-18101"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Cantt.","ps.cnt.btd.police@punjab.gov.in","Jadhav Jayesh Narendra","7","1","75080-18105"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Canal Colony","ps.clcl.btd.police@punjab.gov.in","Suprabhat Kumar","6","1","75080-18103"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Women Cell","ps.wmen.btd.police@punjab.gov.in","Akhil Sevda","6","2","75080-18034"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Thermal","ps.thr.btd.police@punjab.gov.in","MANDA AKHILESH REDDY","8","1","75080-18104"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Sadar","ps.sdr.btd.police@punjab.gov.in","Shanmukha srinivas","10","1","75080-18106"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Sangat","ps.sangat.btd.police@punjab.gov.in","Abhishek Kumar Dwivedi","7","2","75080-18118"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Nehianwala","ps.nhnwla.btd.police@punjab.gov.in","SUBHAJIT PAYRA","5","1","75080-18107"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS City Rampura","ps.rampur.btd.police@punjab.gov.in","Ankit kumar giri","12","1","75080-18111"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Phul","ps.phul.btd.police@punjab.gov.in","RAMAN SINGH","7","1","75080-18110"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Ballianwali","ps.balwli.btd.police@punjab.gov.in","Shaba khatun","5","2","75080-18113"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Dyalpura","ps.dylpur.btd.police@punjab.gov.in","Pavan Yakkali","6","1","75080-18109"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Nathana","ps.nathna.btd.police@punjab.gov.in","Mayank Choudhary","6","1","75080-18108"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Talwandi Sabo","ps.tlwdsb.btd.police@punjab.gov.in","Nevil Sutaria","7","2","75080-18116"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Maur","ps.maur.btd.police@punjab.gov.in","Shivam kumar","12","1","75080-18115"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Kotfatta","ps.kotfta.btd.police@punjab.gov.in","Shruti Tandon","11","1","75080-18114"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Nandgarh","ps.ndh.btd.police@punjab.gov.in","Shubhanshoo dwivedi","10","1","75080-18119"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Raman","ps.raman.btd.police@punjab.gov.in","Vijay kumar","10","2","75080-18117"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS Sadar Rampura","ps.sdrrp.btd.police2punjab.gov.in","Aditya Gaur","8","1","75080-18112"));
        arrayList.add(new policestation("Punjab"," BATHINDA","PS NRI","ps.nri.btd.police@punjab.gov.in","Ojasi","5","1","98157-70363"));
        arrayList.add(new policestation("Punjab"," FARIDKOT","PS City","ps.cty.frd.police@punjab.gov.in","Satyendra yadav","5","1","78370-18031"));
        arrayList.add(new policestation("Punjab"," FARIDKOT","PS Sadar","ps.sdr.frd.police@punjab.gov.in","Akash kushwah","5","1","78370-18032"));
        arrayList.add(new policestation("Punjab"," FARIDKOT","PS City Kotkapura","ps.ctykkp.frd.police@punjab.gov.in","Khushal pariskar","12","2","78370-18034"));
        arrayList.add(new policestation("Punjab"," FARIDKOT","PS Sadar Kotkapura","ps.sdrkkp.frd.police@punjab.gov.in","Ganguly kumar","6","2","78370-18035"));
        arrayList.add(new policestation("Punjab"," FARIDKOT","PS Jaito","ps.jaito.frd.police@punjab.gov.in","Aman Shaukat","5","1","78370-18036"));
        arrayList.add(new policestation("Punjab"," FARIDKOT","PS Sadiq","ps.sadiq.frd.police@punjab.gov.in","Om saxena","5","2","78370-18033"));
        arrayList.add(new policestation("Punjab"," FARIDKOT","PS Baja Khana","ps.bjkn.frd.police@punjab.gov.in","Ujjwal Kumar","11","2","78370-18037"));
        arrayList.add(new policestation("Punjab"," FATEHGARH SAHIB","PS Fatehgarh Sahib","ps.ftg.police@punjab.gov.in","Uppala Manoj","6","2","85588-18109"));
        arrayList.add(new policestation("Punjab"," FATEHGARH SAHIB","PS Sirhind","ps.srhind.ftg.police@punjab.gov.in","Mayur Lilani","7","1","85588-18110"));
        arrayList.add(new policestation("Punjab"," FATEHGARH SAHIB","PS Mullepur","ps.mlpr.ftg.police@punjab.gov.in","Hritik Gupta","10","1","85599-18111"));
        arrayList.add(new policestation("Punjab"," FATEHGARH SAHIB","PS Amloh","ps.amloh.ftg.police@punjab.gov.in","Bidut Karki","11","2","85588-18114"));
        arrayList.add(new policestation("Punjab"," FATEHGARH SAHIB","PS Gobindgarh","ps.gbdgrh.ftg.police@punjab.gov.in","Amit Kumar","8","2","85588-18115"));
        arrayList.add(new policestation("Punjab"," FATEHGARH SAHIB","PS Khamano","ps.khmnon.ftg.police@punjab.gov.in","ASHISH KUMAR","7","1","85588-18116"));
        arrayList.add(new policestation("Punjab"," FATEHGARH SAHIB","PS Badali Ala Singh","ps.bdlas.ftg.police@punjab.gov.in","Priyanshu Bhardwaj","11","2","85588-18113"));
        arrayList.add(new policestation("Punjab"," FATEHGARH SAHIB","PS Bassi Pathana","ps.bspth.ftg.police@punjab.gov.in","Abhay singh","8","1","85588-18112"));
        arrayList.add(new policestation("Punjab"," FAZILKA","PS Sadar","ps.sdr.fzk.police@punjab.gov.in","Rahul Nainala","12","1","85588-00813"));
        arrayList.add(new policestation("Punjab"," FAZILKA","PS City","ps.cty.fzk.police@punjab.gov.in","Shagun agrawal","8","2","85588-00814"));
        arrayList.add(new policestation("Punjab"," FAZILKA","PS City Jalalabad","ps.ctyjbd.fzk.police@punjab.gov.in","Rittike Ghosh","9","2","85588-00812"));
        arrayList.add(new policestation("Punjab"," FAZILKA","PS Sadar Abohar","ps.sdrabr.fzk.police@punjab.gov.in","Devraj","11","2","85588-00819"));
        arrayList.add(new policestation("Punjab"," FAZILKA","PS City-1 Abohar","ps.ctyabr.fzk.police@punjab.gov.in","Aman Kumar","11","1","85588-00816"));
        arrayList.add(new policestation("Punjab"," FAZILKA","PS City-2 Abohar","ps.c2abrfzk.police@punjab.gov.in","Aayush Thakur","7","1","85588-00817"));
        arrayList.add(new policestation("Punjab"," FAZILKA","PS Bahav Wala","ps.bvwl.fzk.police@punjab.gov.in","Avantika Awasthi","8","2","85588-00820"));
        arrayList.add(new policestation("Punjab"," FAZILKA","PS Sadar Jalalabad","ps.sjlbd.fzk.police@punjab.gov.in","Abhi kumae","6","1","85588-00811"));
        arrayList.add(new policestation("Punjab"," FAZILKA","PS Arni Wala","ps.anwl.fzk.police@punjab.gov.in","Mayank Bist","6","2","85588-00815"));
        arrayList.add(new policestation("Punjab"," FAZILKA","PS Khuian Sarwar","ps.kusrwr.fzk.police@punjab.gov.in","Avijeet pandey","10","2","85588-00818"));
        arrayList.add(new policestation("Punjab"," FEROZEPUR","PS City","ps.cty.frz.police@punjab.gov.in","Amit Singh","12","1","85588-27310"));
        arrayList.add(new policestation("Punjab"," FEROZEPUR","PS Sadar","ps.sdr.frz.police@punjab.gov.in","Aditya Kumar","10","1","85588-27311"));
        arrayList.add(new policestation("Punjab"," FEROZEPUR","PS Cantt.","ps.cnt.frz.police@punjab.gov.in","Alok Kumar Goldy","8","2","85588-27312"));
        arrayList.add(new policestation("Punjab"," FEROZEPUR","PS Makhu","ps.makhu.frz.police@punjab.gov.in","Tushar Rathee","7","2","85588-27319"));
        arrayList.add(new policestation("Punjab"," FEROZEPUR","PS Zira","ps.zira.frz.police@punjab.gov.in","Sai Lokesh Reddy","8","1","85588-27318"));
        arrayList.add(new policestation("Punjab"," FEROZEPUR","PS Mallanwala","ps.mlnwla.frz.police@punjab.gov.in","Siddharth kumar","6","2","85588-27320"));





        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,districts);
        district_spinner.setAdapter(arrayAdapter);
        district_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                List<policestation> districtwise = new ArrayList<>();
//                Toast.makeText(KypActivity.this, parent.getSelectedItem().toString()+"", Toast.LENGTH_SHORT).show();
                for (policestation p:arrayList){
                    if (p.getDistrict().equals(parent.getSelectedItem().toString())){
                        districtwise.add(p);
                        Log.d(p.district,p.nameofStation);
                        Log.d("true","true");
                    }
                    else{
                        Log.d("data", "false: ");
                    }
                }
                if (districtwise.size() == 0){
                    Toast.makeText(KypActivity.this, "empty", Toast.LENGTH_SHORT).show();
                }

                adapter = new KypAdapter(districtwise, view.getContext());
                ls.setAdapter(adapter);




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }
}
