package com.usu.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.usu.materialdesign.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
//        binding.topAppBar.setNavigationOnClickListener((view) -> {
//            System.out.println("Hello, world!");
//        });

//        binding.myText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Viverra accumsan in nisl nisi scelerisque eu ultrices vitae. Etiam erat velit scelerisque in dictum non consectetur. Pharetra et ultrices neque ornare. Leo in vitae turpis massa sed elementum tempus. Elit sed vulputate mi sit amet mauris commodo quis imperdiet. Morbi tristique senectus et netus. Est pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat. Lacus suspendisse faucibus interdum posuere lorem ipsum dolor sit. Vehicula ipsum a arcu cursus vitae congue mauris. Suspendisse ultrices gravida dictum fusce ut placerat. Feugiat scelerisque varius morbi enim nunc faucibus a pellentesque sit. Est lorem ipsum dolor sit amet consectetur adipiscing elit pellentesque. Iaculis eu non diam phasellus vestibulum lorem sed risus. Nibh sit amet commodo nulla facilisi nullam vehicula. Aliquam eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis. Euismod nisi porta lorem mollis aliquam ut. Mauris pharetra et ultrices neque. Ut etiam sit amet nisl purus. In hac habitasse platea dictumst vestibulum rhoncus est pellentesque.\n" +
//                "\n" +
//                "Faucibus vitae aliquet nec ullamcorper sit amet. Eu tincidunt tortor aliquam nulla facilisi cras. Mi sit amet mauris commodo quis imperdiet massa tincidunt nunc. Tristique sollicitudin nibh sit amet commodo nulla. Dui accumsan sit amet nulla facilisi morbi tempus iaculis. Morbi leo urna molestie at elementum eu facilisis sed odio. Duis at tellus at urna condimentum. Interdum velit euismod in pellentesque massa placerat. Tortor at auctor urna nunc id cursus metus. Egestas dui id ornare arcu odio ut sem nulla. Turpis egestas sed tempus urna et pharetra. Turpis nunc eget lorem dolor sed viverra. Nascetur ridiculus mus mauris vitae ultricies leo integer malesuada. Vestibulum morbi blandit cursus risus at ultrices mi tempus imperdiet. Volutpat blandit aliquam etiam erat velit scelerisque in dictum. Etiam dignissim diam quis enim lobortis scelerisque. Et odio pellentesque diam volutpat commodo sed egestas egestas fringilla. Id nibh tortor id aliquet lectus proin nibh.\n" +
//                "\n" +
//                "Sollicitudin aliquam ultrices sagittis orci a scelerisque purus. Ridiculus mus mauris vitae ultricies leo integer malesuada nunc vel. Placerat orci nulla pellentesque dignissim enim sit amet. Netus et malesuada fames ac turpis. Consequat mauris nunc congue nisi vitae suscipit tellus mauris a. Sit amet nisl purus in mollis. Cursus eget nunc scelerisque viverra mauris. Pretium vulputate sapien nec sagittis aliquam malesuada bibendum arcu. Potenti nullam ac tortor vitae purus. Non blandit massa enim nec dui nunc mattis enim ut. Sit amet risus nullam eget. Neque aliquam vestibulum morbi blandit cursus.\n" +
//                "\n" +
//                "Elit eget gravida cum sociis natoque. Consequat id porta nibh venenatis cras sed felis eget velit. Aliquam malesuada bibendum arcu vitae elementum curabitur vitae nunc sed. Lacus sed turpis tincidunt id aliquet risus feugiat in ante. Turpis egestas integer eget aliquet nibh praesent tristique magna. In dictum non consectetur a erat nam. Amet tellus cras adipiscing enim. Nibh praesent tristique magna sit amet. Lacus luctus accumsan tortor posuere ac ut consequat semper viverra. Molestie at elementum eu facilisis sed odio morbi quis commodo. Quam lacus suspendisse faucibus interdum posuere lorem. Sagittis vitae et leo duis ut diam quam nulla porttitor. Netus et malesuada fames ac turpis egestas integer eget aliquet. Auctor augue mauris augue neque gravida in. Non diam phasellus vestibulum lorem sed risus ultricies tristique nulla.\n" +
//                "\n" +
//                "Aliquam ut porttitor leo a. Augue interdum velit euismod in pellentesque massa placerat duis ultricies. Sagittis id consectetur purus ut faucibus. Metus vulputate eu scelerisque felis imperdiet proin fermentum leo. Sed velit dignissim sodales ut. Sed odio morbi quis commodo odio. Neque egestas congue quisque egestas diam in arcu. Mauris a diam maecenas sed enim ut sem. Amet risus nullam eget felis eget. At tellus at urna condimentum mattis. Et netus et malesuada fames ac turpis egestas sed tempus.");
        setContentView(binding.getRoot());

    }
}