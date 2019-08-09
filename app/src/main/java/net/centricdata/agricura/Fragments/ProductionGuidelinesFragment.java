package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.centricdata.agricura.Fragments.Crops.Potatoes;
import net.centricdata.agricura.Fragments.Crops.TomatoesFragment;
import net.centricdata.agricura.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductionGuidelinesFragment extends Fragment {

    ListView pdfList;
    String [] item;


    public ProductionGuidelinesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Crop Production Guidelines");
        View view = inflater.inflate(R.layout.fragment_production_guidelines, container, false);

        //PDFView p = view.findViewById(R.id.pdfView);
       // p.fromAsset("1HA-POTATOES-2017-2AGRICURA.pdf").load();

        pdfList = view.findViewById(R.id.productiveGList);
        item = getResources().getStringArray(R.array.pdfNames);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(),
                R.layout.row_productionguidlines,
                item
        );

        pdfList.setAdapter(adapter);

        pdfList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectectedPdf = String.valueOf(pdfList.getItemIdAtPosition(position));
                        String pdfname = "";



                        switch (selectectedPdf){

                            case "1":
                                //pdfname = "1HA-TOMATOE-2017-1-AGRICURA.pdf";

                                //openPdfScreen(pdfname);
                                Fragment fragment = new TomatoesFragment();

                                FragmentTransaction ft = getFragmentManager().beginTransaction();
                                ft.replace(R.id.content_main, fragment);
                                ft.addToBackStack(null);
                                ft.commit();


                                break;
                            case "0":
                                //pdfname = "1HA-POTATOES-2017-2AGRICURA.pdf";

                                //openPdfScreen(pdfname);

                                fragment = new Potatoes();

                                ft = getFragmentManager().beginTransaction();
                                ft.replace(R.id.content_main, fragment);
                                ft.addToBackStack(null);
                                ft.commit();
                                break;
                            case "2":
                                pdfname = "1HA-CABBAGES-2017-1-AGRICURA.pdf";

                                openPdfScreen(pdfname);
                                break;

                            case "3":
                                pdfname = "1HA-BUTTERNUTS-2017-1-AGRICURA.pdf";

                                openPdfScreen(pdfname);
                                break;

                            case "4":
                                pdfname = "1HA-PAPRIKA-2017-1-AGRICURA.pdf";

                                openPdfScreen(pdfname);
                                break;

                            case "5":
                                pdfname = "1HA-WHEAT-2017-AGRICURA.pdf";

                                openPdfScreen(pdfname);
                                break;

                            case "6":
                                pdfname = "1HA-WATER-MELON-2017-1-AGRICURA.pdf";

                                openPdfScreen(pdfname);
                                break;

                            case "7":
                                pdfname = "1HA-TOBACCO-LANDS-2017-1-AGRICURA.pdf";

                                openPdfScreen(pdfname);
                                break;

                            case "8":
                                pdfname = "1HA-SOYABEAN-2017-2-AGRICURA.pdf";

                                openPdfScreen(pdfname);
                                break;

                            case "9":
                                pdfname = "1HA-SORGHUM-2017-2AGRICURA.pdf";

                                openPdfScreen(pdfname);
                                break;

                            case "10":
                                pdfname = "1HA-ONION-2017-1-AGRICURA.pdf";

                                openPdfScreen(pdfname);
                                break;

                            case "11":
                                pdfname = "1HA-BUTTERNUTS-2017-1-AGRICURA.pdf";

                                openPdfScreen(pdfname);
                                break;

                            case "12":
                                pdfname = "1HA-CARROTS-2017-1-AGRICURA.pdf";

                                openPdfScreen(pdfname);
                                break;

                            case "13":
                                pdfname = "1HA-COTTON-2017-1-AGRICURA.pdf";

                                openPdfScreen(pdfname);
                                break;

                            case "14":
                                pdfname = "1HA-CUCUMBERS-2017-1-AGRICURA.pdf";

                                openPdfScreen(pdfname);
                                break;

                            case "15":
                                pdfname = "1HA-GROUNDNUTS-2017-1-AGRICURA.pdf";

                                openPdfScreen(pdfname);
                                break;

                        }

                    }
                }
        );






        return view;
    }

    private void openPdfScreen(String pdfname) {

        Bundle bundle = new Bundle();
        bundle.putString("pdfnmae" ,pdfname );

        Fragment fragment = new PdfViewFragment();

        fragment.setArguments(bundle);


        FragmentTransaction ft =  getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_main, fragment);
        ft.addToBackStack("pdf");
        ft.commit();

    }


}
